import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// C言語では、#include に相当する

/**
 *
 * @author wisteria
 */

public class HowOldAreYou {

	public static void main(String[] args) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader というのは、データ読み込みのクラス(型)
		// クラスの変数を作るには、new を使う。

		// readLine() は、入出力エラーの可能性がある。エラー処理がないとコンパイルできない。
		// Java では、 try{ XXXXXXXX } catch(エラーの型 変数) { XXXXXXXXXXXXXXXXXX} と書く
		try {
			System.out.println("何歳ですか?");
			String line = reader.readLine();
			int age = Integer.parseInt(line);
			int[] era = {2019, 1989, 1926, 1912, 1868};
			String[] era2 = {"令和", "平成", "昭和", "大正", "明治"};

			if (age < 0 || age > 120) {
				System.out.println("年齢は0から120の間で入力してください。");
			} else {
				System.out.println("あなたは" + age + "歳ですね。");
				System.out.println("あなたは2030年では、" + (age + 6) + "歳ですね。");
				for (int i = 0; i < 5; i++) {
					if (2024 - age - era[i] > 0) {
						System.out
								.println("あなたは" + era2[i] + (2024 - age - era[i] + 1) + "年生まれです。");
						break;
					}
				}
			}
		} catch (IOException e) {
			System.out.println(e);
			main(args);
		} catch (NumberFormatException e) {
			System.out.println("数字を入力してください。");
			main(args);
		}

	}
}

// 課題 キーボードから数字を打ち込む
// その結果、 あなたは、???歳ですね、と画面に表示させる。
// その後、あなたは10年後、????歳ですね、と画面に表示させる。
