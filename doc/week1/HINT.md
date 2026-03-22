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

---

## Day 3 ヒント — `ExpenseController.java`

### TODO (1) — コントローラーアノテーション

<details>
<summary>💡 ヒントを見る</summary>

Spring MVC のコントローラーには `@Controller` アノテーションを付けます。

```java
@Controller
public class ExpenseController {
```

`@RestController` との違い: `@Controller` はHTMLを返す画面用、`@RestController` はJSONを返すAPI用です。今回は画面を返すので `@Controller` を使います。

</details>

---

### TODO (2) — GETメソッドのマッピング

<details>
<summary>💡 ヒントを見る</summary>

`@GetMapping("URL")` でGETリクエストのURLとメソッドを紐付けます。

```java
@GetMapping("/expenses/new")
public String newExpenseForm(Model model) {
```

ブラウザでURLを入力してアクセスするのはGETリクエストです。

</details>

---

### TODO (3) — モデルにオブジェクトを追加

<details>
<summary>💡 ヒントを見る</summary>

`model.addAttribute("名前", オブジェクト)` でHTMLに渡すデータを登録します。

```java
model.addAttribute("expense", new Expense());
```

Thymeleafの `th:object="${expense}"` がこの "expense" を受け取ります。

</details>

---

### TODO (4) — テンプレート名を返す

<details>
<summary>💡 ヒントを見る</summary>

`return "フォルダ名/ファイル名"` でHTMLファイルを指定します（拡張子不要）。

```java
return "expenses/new";
// → src/main/resources/templates/expenses/new.html が表示される
```

</details>

---

### TODO (5) — POSTメソッドのマッピング

<details>
<summary>💡 ヒントを見る</summary>

フォームの `method="post"` に対応するには `@PostMapping` を使います。

```java
@PostMapping("/expenses")
public String createExpense(@ModelAttribute Expense expense) {
```

`@ModelAttribute` はフォームの入力値を自動的に `Expense` オブジェクトに詰めてくれます。

</details>

---

### TODO (6) — リダイレクト

<details>
<summary>💡 ヒントを見る</summary>

Springでリダイレクトするには `"redirect:/URL"` を返します。

```java
return "redirect:/expenses/new";
```

保存後に同じフォーム画面に戻ります。

</details>

---

## Day 3 ヒント — `input.html`

### TODO (1) — Thymeleaf の宣言

<details>
<summary>💡 ヒントを見る</summary>

`th:` 属性を使うために `xmlns:th` を `<html>` タグに追加します。

```html
<html xmlns:th="http://www.thymeleaf.org">
```

これがないと `th:field` などが認識されません。

</details>

---

### TODO (2) — フォームタグの設定

<details>
<summary>💡 ヒントを見る</summary>

```html
<form th:action="@{/expenses}" th:object="${expense}" method="post">
```

- `th:action="@{/expenses}"` → 送信先URLを `/expenses` に指定
- `th:object="${expense}"` → コントローラーで渡した `expense` オブジェクトをフォーム全体で使う
- `@{...}` はThymeleafのURL記法です

</details>

---

### TODO (3)(4)(5)(6) — th:field の書き方

<details>
<summary>💡 ヒントを見る</summary>

`th:field="*{フィールド名}"` でJavaのフィールドと入力欄を紐付けます。

```html
<input type="number" th:field="*{amount}"/>
<input type="text"   th:field="*{category}"/>
<input type="text"   th:field="*{memo}"/>
<input type="date"   th:field="*{expenseDate}"/>
```

`*{...}` は `th:object` で指定したオブジェクト（expense）の中を見る記法です。

> **AI活用ポイント** 💬  
> 「Thymeleafのth:fieldとは何ですか？普通のname属性との違いを教えてください」と聞いてみましょう。

</details>

---

## 📖 参考リンク

- [Spring Data JPA 公式ドキュメント](https://spring.io/projects/spring-data-jpa)
- [Jakarta Persistence アノテーション一覧](https://jakarta.ee/specifications/persistence/)