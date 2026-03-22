package com.example.kakeibo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * 【Week 1 - 穴埋め課題】Expense（支出）エンティティクラス
 *
 * このクラスはデータベースの "expenses" テーブルと対応します。
 * TODO のコメントがある箇所を埋めて完成させてください。
 *
 * ヒントは HINT.md を参照してください。
 */

// TODO (1): このクラスをJPAエンティティとして認識させるアノテーションを付けてください
// TODO (2): 対応するテーブル名を "expenses" に指定するアノテーションを付けてください
public class Expense {

    // TODO (3): このフィールドを主キーとして設定するアノテーションを付けてください
    // TODO (4): IDを自動採番（AUTO INCREMENT）にするアノテーションを付けてください
    private Long id;

    // 支出金額（例: 500）
    // TODO (5): NULLを許可しない制約のアノテーションを付けてください
    private Integer amount;

    // カテゴリ（例: "食費", "交通費", "娯楽費"）
    // TODO (6): NULLを許可しない制約のアノテーションを付けてください
    private String category;

    // メモ（任意入力）
    private String memo;

    // 支出日（例: 2024-04-01）
    // TODO (7): NULLを許可しない制約のアノテーションを付けてください
    private LocalDate expenseDate;

    // -----------------------------------------------------------
    // コンストラクタ
    // -----------------------------------------------------------

    // TODO (8): 引数なしのデフォルトコンストラクタを定義してください
    // （JPAが内部で使用するために必要です）


    // TODO (9): 全フィールドを引数に取るコンストラクタを定義してください
    // 引数: amount, category, memo, expenseDate


    // -----------------------------------------------------------
    // ゲッター・セッター
    // -----------------------------------------------------------

    // TODO (10): 各フィールドのゲッターとセッターを定義してください
    // getId() / setId(Long id)
    // getAmount() / setAmount(Integer amount)
    // getCategory() / setCategory(String category)
    // getMemo() / setMemo(String memo)
    // getExpenseDate() / setExpenseDate(LocalDate expenseDate)


    // -----------------------------------------------------------
    // toStringメソッド（デバッグ用・任意）
    // -----------------------------------------------------------

    // TODO (11): 【チャレンジ】toStringメソッドをオーバーライドしてください
    // 出力例: "Expense{id=1, amount=500, category='食費', expenseDate=2024-04-01}"

}