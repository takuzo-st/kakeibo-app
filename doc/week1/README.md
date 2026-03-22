# Week 1 — Spring Boot 入門 & Expense モデル設計

> **目標**: Spring Boot の環境に慣れ、支出データを表すクラス（`Expense`）を自分の手で完成させる。  
> **成果物**: フォームから支出を入力できる画面が動く状態

---

## 📅 学習スケジュール（目安）

| Day | テーマ | 所要時間 |
|-----|--------|---------|
| Day 1 | プロジェクト構成を理解する | 60分 |
| Day 2 | `Expense.java` の穴埋め（モデル設計） | 90分 |
| Day 3 | 入力フォーム画面を作る | 90分 |
| Day 4 | 動作確認 & AIレビュー | 60分 |
| Day 5 | 振り返り & 次週の準備 | 30分 |

---

## 🗂 この週のファイル構成

```
docs/week1/
├── README.md          ← いまここ
├── HINT.md            ← 詰まったときのヒント集
└── ANSWER.md          ← 答え合わせ用（完成後に見ること！）

src/main/java/com/example/kakeibo/
└── model/
    └── Expense.java   ← 【穴埋め対象】
```

---

## Day 1 — プロジェクト構成を理解する

### Spring Boot プロジェクトの全体像

```
kakeibo-app/
├── src/
│   ├── main/
│   │   ├── java/com/example/kakeibo/
│   │   │   ├── KakeiboApplication.java   ← アプリの起動点
│   │   │   ├── controller/               ← リクエストを受け取る
│   │   │   ├── service/                  ← ビジネスロジック
│   │   │   ├── repository/               ← DBとのやりとり
│   │   │   └── model/                    ← データの形を定義 ★今週はここ
│   │   └── resources/
│   │       ├── templates/                ← HTML画面（Thymeleaf）
│   │       └── application.properties    ← 設定ファイル
└── pom.xml                               ← 使うライブラリの一覧
```

### 📖 各レイヤーの役割

```
ブラウザ
   ↕
Controller   … URLを受け取り、画面を返す
   ↕
Service      … 「保存して」「一覧を取って」などの処理を行う
   ↕
Repository   … データベースへの読み書きを担当
   ↕
Database（MySQL）
```

**Model**（今週の対象）はこの全レイヤーで使われる「データの型」です。  
「支出1件」がどんな情報を持つか、をクラスとして定義します。

### ✅ Day 1 チェック

- [ ] `KakeiboApplication.java` を開いて、`main` メソッドを確認した
- [ ] `application.properties` を開いて、DB設定を確認した
- [ ] ブラウザで `http://localhost:8080` を開いてアプリが起動していることを確認した

---

## Day 2 — `Expense.java` の穴埋め（モデル設計）

### 支出データとは何か

家計簿アプリに必要な「支出1件分」の情報を考えてみましょう。

| 項目 | 例 | Javaの型 |
|------|-----|---------|
| ID（識別番号） | 1, 2, 3 … | `Long` |
| 金額 | 500（円） | `Integer` |
| カテゴリ | "食費" | `String` |
| メモ | "コンビニでランチ" | `String` |
| 支出日 | 2024-04-01 | `LocalDate` |

### JPAアノテーションとは

**JPA（Java Persistence API）** を使うと、Javaのクラスをそのままデータベースのテーブルとして扱えます。  
`@Entity` などの「アノテーション」を付けることで、JPAがクラスの使い方を理解します。

| アノテーション | 意味 |
|--------------|------|
| `@Entity` | このクラスはDBのテーブルに対応する |
| `@Table(name="...")` | 対応するテーブル名を指定する |
| `@Id` | このフィールドが主キー（ID）である |
| `@GeneratedValue` | IDを自動採番する |
| `@Column(nullable=false)` | NULLを許可しない（必須項目） |

### 課題: `Expense.java` を完成させる

`src/main/java/com/example/kakeibo/model/Expense.java` を開き、  
`// TODO` のコメントをすべて埋めてください。

詰まったら `HINT.md` を確認してください。

### ✅ Day 2 チェック

- [ ] `Expense.java` の TODO を (1)〜(11) すべて埋めた
- [ ] コンパイルエラーが出ていないことを確認した
- [ ] アプリを再起動して、エラーなく起動することを確認した

---

## Day 3 — 入力フォーム画面を作る

### Controller を理解する

`Expense.java` が完成したら、次は「フォームを表示する画面」を作ります。  
以下のファイルを確認・編集してください。

**`src/main/java/com/example/kakeibo/controller/ExpenseController.java`**

```java
@Controller
public class ExpenseController {

    // GET /expenses/new → 入力フォーム画面を表示
    @GetMapping("/expenses/new")
    public String newExpenseForm(Model model) {
        model.addAttribute("expense", new Expense());
        return "expenses/new";   // templates/expenses/new.html を表示
    }
}
```

**`src/main/resources/templates/expenses/new.html`**

Thymeleaf という HTML テンプレートエンジンを使います。  
`th:field` で Java のフィールドと HTML の入力欄を紐付けます。

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<body>
  <h1>支出を入力する</h1>
  <form th:action="@{/expenses}" th:object="${expense}" method="post">
    <label>金額: <input type="number" th:field="*{amount}"/></label>
    <label>カテゴリ: <input type="text" th:field="*{category}"/></label>
    <label>メモ: <input type="text" th:field="*{memo}"/></label>
    <label>日付: <input type="date" th:field="*{expenseDate}"/></label>
    <button type="submit">保存</button>
  </form>
</body>
</html>
```

### ✅ Day 3 チェック

- [ ] `http://localhost:8080/expenses/new` を開いてフォームが表示された
- [ ] 金額・カテゴリ・メモ・日付の入力欄が表示されている
- [ ] 「保存」ボタンをクリックしてもエラー画面にならない（Week 2でDB保存を実装）

---

## Day 4 — 動作確認 & AI レビュー

### AIを使ったコードレビューの方法

完成した `Expense.java` をAIにレビューしてもらいましょう。  
以下のプロンプトをコピーして使ってください。

---

**📋 AIレビュー依頼プロンプト（コピーして使う）**

```
以下はSpring Boot + JPAで作った家計簿アプリのEntityクラスです。
初心者が書いたコードとして、改善点・問題点・良い点を教えてください。

【コード】
（ここに Expense.java の全文を貼り付ける）

【確認してほしいこと】
- JPAアノテーションの使い方は正しいか
- フィールドの型は適切か
- 初心者がよく間違える落とし穴はあるか
```

---

### エラーが出たときのAIデバッグ方法

```
以下のエラーが出ています。原因と修正方法を教えてください。

【エラーメッセージ】
（エラーの全文をここに貼り付ける）

【該当コード】
（エラーが出ているクラスのコードをここに貼り付ける）

【環境】
Spring Boot 3 / Java 17 / H2 Database
```

### ✅ Day 4 チェック

- [ ] AIにコードレビューを依頼した
- [ ] AIの指摘を読んで、理解できた（修正は任意）
- [ ] `ANSWER.md` と自分のコードを比べた

---

## Day 5 — 振り返り & 次週の準備

### 振り返りシート

以下の質問に答えてみてください（メモ帳でもOK）。

1. **今週一番難しかったこと**は何ですか？
2. **JPAアノテーション**を自分の言葉で説明できますか？
3. **AIを使って解決できたこと**はありましたか？どんな質問をしましたか？

### 次週（Week 2）の予告

- H2データベースに接続する
- `ExpenseService.java` を実装して、フォームから入力したデータを保存する
- 保存した支出を一覧画面に表示する

### ✅ Day 5 チェック

- [ ] 振り返りシートを記入した
- [ ] Git に `Expense.java` をコミットした（`git commit -m "Week1: Expenseモデル完成"`）
- [ ] Week 2 の README を開いて次週の内容を確認した

---

## 🆘 困ったときは

| 状況 | 対処法 |
|------|--------|
| コードの意味がわからない | `HINT.md` を見る → AIに質問する |
| エラーが消えない | エラー全文をAIに貼って質問する |
| フォームが表示されない | `http://localhost:8080/expenses/new` のURLを確認する |
| アプリが起動しない | コンソールの最初のエラーメッセージをAIに質問する |

---

*Week 1 / 4 — 次: [Week 2 DB・CRUD](../week2/README.md)*