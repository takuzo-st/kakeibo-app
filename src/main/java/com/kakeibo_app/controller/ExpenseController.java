package com.kakeibo_app.controller;

import com.kakeibo_app.model.Expense;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * 【Week 1 Day 3 - 穴埋め課題】ExpenseController
 *
 * ブラウザからのリクエストを受け取り、画面を返すクラスです。
 * TODO のコメントがある箇所を埋めて完成させてください。
 *
 * ヒントは HINT.md を参照してください。
 */

// TODO (1): このクラスをSpring MVCのコントローラーとして認識させるアノテーションを付けてください
public class ExpenseController {

    // TODO (2): GET /expenses/input にアクセスしたときに呼ばれるメソッドに
    //           マッピングするアノテーションを付けてください
    public String inputExpenseForm(Model model) {

        // TODO (3): "expense" という名前で 新しい Expense オブジェクトを
        //           model に追加してください
        //           （Thymeleafのフォームがこのオブジェクトを使います）


        // TODO (4): templates/expenses/input.html を表示するために
        //           適切な文字列を return してください
        return "";
    }

    // TODO (5): POST /expenses にアクセスしたときに呼ばれるメソッドに
    //           マッピングするアノテーションを付けてください
    //           （フォームの「保存」ボタンを押したときの処理です）
    public String createExpense(@ModelAttribute Expense expense) {

        // Week 2 で保存処理を実装します。今はコンソールに出力するだけでOKです。
        System.out.println("受け取った支出データ: " + expense);

        // TODO (6): フォーム送信後に /expenses/input へリダイレクトしてください
        //           Springでリダイレクトするときは "redirect:/..." の形式を使います
        return "";
    }
}