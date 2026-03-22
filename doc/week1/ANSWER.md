# Week 1 — 答え合わせ

> ⚠️ **必ず自分で穴埋めを完成させてから開いてください。**  
> 先に答えを見ると、学習効果が大きく下がります。

---

## `Expense.java` 完成コード

```java
package com.example.kakeibo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity                          // TODO (1)
@Table(name = "expenses")        // TODO (2)
public class Expense {

    @Id                                                        // TODO (3)
    @GeneratedValue(strategy = GenerationType.IDENTITY)        // TODO (4)
    private Long id;

    @Column(nullable = false)    // TODO (5)
    private Integer amount;

    @Column(nullable = false)    // TODO (6)
    private String category;

    private String memo;         // 任意入力なので nullable = false は不要

    @Column(nullable = false)    // TODO (7)
    private LocalDate expenseDate;

    // TODO (8) デフォルトコンストラクタ
    public Expense() {
    }

    // TODO (9) 全フィールドコンストラクタ（id は自動採番のため含めない）
    public Expense(Integer amount, String category, String memo, LocalDate expenseDate) {
        this.amount = amount;
        this.category = category;
        this.memo = memo;
        this.expenseDate = expenseDate;
    }

    // TODO (10) ゲッター・セッター
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getAmount() { return amount; }
    public void setAmount(Integer amount) { this.amount = amount; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getMemo() { return memo; }
    public void setMemo(String memo) { this.memo = memo; }

    public LocalDate getExpenseDate() { return expenseDate; }
    public void setExpenseDate(LocalDate expenseDate) { this.expenseDate = expenseDate; }

    // TODO (11) チャレンジ: toString
    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", amount=" + amount +
                ", category='" + category + '\'' +
                ", expenseDate=" + expenseDate +
                '}';
    }
}
```

---

## 解説：なぜこう書くのか

### `@Entity` と `@Table`

```java
@Entity
@Table(name = "expenses")
```

`@Entity` だけでも動きますが、テーブル名がクラス名（`expense`）になってしまいます。  
複数形（`expenses`）にするのが一般的な慣習なので `@Table` で明示します。

### `@GeneratedValue(strategy = GenerationType.IDENTITY)`

```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

`GenerationType.IDENTITY` は MySQL・H2 の `AUTO_INCREMENT` を使う設定です。  
他の選択肢として `SEQUENCE`（PostgreSQL向け）や `AUTO`（DB依存）があります。

### `Long` vs `int`

`Long`（大文字）を使う理由は、**null を扱えるから**です。  
保存前の新しいオブジェクトは `id` がまだ決まっていない（null）ため、  
プリミティブ型の `long`（小文字）では null を表せません。

### なぜ `memo` に `nullable = false` を付けないのか

メモは任意入力です。ユーザーが入力しなかった場合は null になります。  
`nullable = false` を付けると、メモなしで保存しようとしたときにエラーになります。

---

## よくある間違い

### ❌ import を忘れる

```java
// これだとコンパイルエラー
@Entity
@Table(name = "expenses")
public class Expense {
```

```java
// ✅ 正しい
import jakarta.persistence.*;   // ← これが必要
```

### ❌ `jakarta` ではなく `javax` を書いてしまう

Spring Boot 3 からは `jakarta.persistence` です。  
Spring Boot 2 以前の記事を見ると `javax.persistence` と書いてありますが、  
Boot 3 では使えないので注意してください。

### ❌ デフォルトコンストラクタを書き忘れる

全フィールドのコンストラクタだけを書いて、デフォルトコンストラクタを省略すると  
JPA が内部でクラスを生成できずエラーになります。

```
No default constructor for entity: Expense
```

こんなエラーが出たらデフォルトコンストラクタが足りないサインです。

---

## 次のステップ

`Expense.java` が完成したら、Week 2 では Service と Repository を実装して  
実際にデータをデータベースへ保存できるようにします。

*← [Week 1 README に戻る](README.md) | [Week 2 へ →](../week2/README.md)*