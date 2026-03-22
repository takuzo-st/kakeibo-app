# Week 1 ヒント集 — `Expense.java` 穴埋め課題

> **使い方**: 穴埋めに詰まったら、該当する番号のヒントを確認してください。  
> いきなり「答え」を見るより、まず自分で考えてみることをおすすめします。

---

## ヒント一覧

### TODO (1) — エンティティアノテーション

<details>
<summary>💡 ヒントを見る</summary>

JPAでクラスをDBテーブルと対応させるには `@Entity` アノテーションを使います。

```java
import jakarta.persistence.Entity;

@Entity
public class Expense { ... }
```

</details>

---

### TODO (2) — テーブル名の指定

<details>
<summary>💡 ヒントを見る</summary>

`@Table(name = "テーブル名")` でDBのテーブル名を明示的に指定できます。

```java
@Entity
@Table(name = "expenses")
public class Expense { ... }
```

省略するとクラス名がそのままテーブル名になります（`expense`）。  
今回は明示的に `expenses` と指定しましょう。

</details>

---

### TODO (3) — 主キーの設定

<details>
<summary>💡 ヒントを見る</summary>

主キー（Primary Key）には `@Id` アノテーションを付けます。

```java
@Id
private Long id;
```

</details>

---

### TODO (4) — 自動採番

<details>
<summary>💡 ヒントを見る</summary>

IDを自動的に連番にするには `@GeneratedValue` を使います。  
`strategy = GenerationType.IDENTITY` でDBの AUTO_INCREMENT を使えます。

```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

</details>

---

### TODO (5)(6)(7) — NULL制約

<details>
<summary>💡 ヒントを見る</summary>

入力必須のフィールドには `@Column(nullable = false)` を付けます。

```java
@Column(nullable = false)
private Integer amount;

@Column(nullable = false)
private String category;

@Column(nullable = false)
private LocalDate expenseDate;
```

`memo` は任意入力なので、この制約は不要です。

</details>

---

### TODO (8) — デフォルトコンストラクタ

<details>
<summary>💡 ヒントを見る</summary>

JPAはリフレクションを使うため、引数なしのコンストラクタが必要です。

```java
public Expense() {
}
```

コンストラクタの中身は空で問題ありません。

</details>

---

### TODO (9) — 全フィールドコンストラクタ

<details>
<summary>💡 ヒントを見る</summary>

`id` は自動採番のため引数に含めません。  
`amount`, `category`, `memo`, `expenseDate` の4つを引数に取ります。

```java
public Expense(Integer amount, String category, String memo, LocalDate expenseDate) {
    this.amount = amount;
    this.category = category;
    this.memo = memo;
    this.expenseDate = expenseDate;
}
```

</details>

---

### TODO (10) — ゲッター・セッター

<details>
<summary>💡 ヒントを見る</summary>

各フィールドに対して `get○○()` と `set○○(引数)` を定義します。  
例として `amount` のゲッター・セッターを示します。

```java
public Integer getAmount() {
    return amount;
}

public void setAmount(Integer amount) {
    this.amount = amount;
}
```

同じパターンで `id`, `category`, `memo`, `expenseDate` も定義してください。

> **AI活用ポイント** 💬  
> 「Javaのゲッター・セッターを全フィールド分まとめて書いて」とAIに依頼するのも一つの方法です。  
> ただし、AIが生成したコードの意味を1行ずつ確認する習慣をつけましょう。

</details>

---

### TODO (11) — toStringメソッド（チャレンジ）

<details>
<summary>💡 ヒントを見る</summary>

`toString()` は `Object` クラスのメソッドをオーバーライドします。  
デバッグ時にオブジェクトの中身を確認するのに便利です。

```java
@Override
public String toString() {
    return "Expense{" +
            "id=" + id +
            ", amount=" + amount +
            ", category='" + category + '\'' +
            ", expenseDate=" + expenseDate +
            '}';
}
```

> **AI活用ポイント** 💬  
> IDEの自動生成機能や「このクラスのtoStringを書いて」とAIに頼んでみましょう。  
> 生成されたコードが上の例と違う場合、なぜ違うのかAIに聞いてみると理解が深まります。

</details>

---

## ✅ 完成チェックリスト

すべて埋まったら、以下を確認してください。

- [ ] `@Entity` と `@Table(name = "expenses")` がクラスに付いている
- [ ] `id` フィールドに `@Id` と `@GeneratedValue` が付いている
- [ ] `amount`, `category`, `expenseDate` に `@Column(nullable = false)` が付いている
- [ ] デフォルトコンストラクタが定義されている
- [ ] 全フィールドのゲッター・セッターが定義されている
- [ ] アプリを起動して `expenses` テーブルが自動作成されることを確認した

---

## 🤖 AIを活用したデバッグの方法

エラーが出たら、以下のようにAIに質問してみましょう。

```
以下のエラーが出ています。原因と修正方法を教えてください。

【エラーメッセージ】
（エラーの全文をここに貼り付ける）

【該当コード】
（エラーが出ているクラスのコードをここに貼り付ける）
```

> エラーメッセージをそのまま貼るだけで、AIはかなり的確に答えてくれます。  
> 「恥ずかしい質問」はありません。どんどん活用しましょう。

---

## 📖 参考リンク

- [Spring Data JPA 公式ドキュメント](https://spring.io/projects/spring-data-jpa)
- [Jakarta Persistence アノテーション一覧](https://jakarta.ee/specifications/persistence/)