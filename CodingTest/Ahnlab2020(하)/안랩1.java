import java.util.Arrays;

public class 안랩1 {
   // 모음이 4개이상 연속으로 오면 안됨
   // 자음이 4개이상 연속으로 오면 안됨
   // 같은 알파벳이 3개이상 연속으로 오면 안됨
   // 연속된 알파벳이 4개이상 오면 안됨

   public static void main(String[] args) {
      String[] words = { "aeiou", "asdfgh", "yakkke", "abfedc", "xyzabc", "qwertyuiop" };
      int[] answer = solution(words);
      System.out.println(Arrays.toString(answer));
   }

   static public int[] solution(String[] words) {
      int[] answer = new int[words.length];
      for (int i = 0; i < words.length; i++) {
         if (checkvowel(words[i]) || checkConsonant(words[i]) || checkSameAlpha(words[i])
               || checkContinuosAlpha(words[i])) {
            answer[i] = 0;
         } else {
            answer[i] = 1;
         }
      }
      return answer;
   }

   // 같은 알파벳이 연속으로 3개이상 오는지 확인
   static boolean checkSameAlpha(String word) {
      for (int i = 0; i <= word.length() - 3; i++) {
         char ch = word.charAt(i);
         int count = 1;
         // 기준 위치에서 연속 3개를 확인한다
         for (int j = i; j < i + 3; j++) {
            if (ch == word.charAt(j)) {
               count++;
            }
         }
         if (count == 3) // 연속된 3개면 규칙에 위반
            return true;
      }
      return false;
   }

   // 연속된 알파벳이 4개이상 오는지 확인
   static boolean checkContinuosAlpha(String word) {
      for (int i = 0; i <= word.length() - 4; i++) {
         // 기준 위치에서 4개를 확인한다
         int count = 1;
         for (int j = i; j < i + 3; j++) {
            char prev = word.charAt(j);
            char cur = word.charAt(j + 1);
            if (prev + 1 != cur && prev - 1 != cur) { // 확인 도중 아니면 기준위치를 한 칸 넘긴다
               break;
            } else { // 같으면 일단 count를 센다
               count++;
            }
         }
         if (count == 4) // 연속된 4개면 규칙에 위반
            return true;
      }
      return false;
   }

   // 자음이 4개이상 연속으로 오는지 확인
   static boolean checkConsonant(String word) {
      for (int i = 0; i <= word.length() - 4; i++) {
         int count = 0;
         for (int j = i; j < i + 4; j++) {
            char ch = word.charAt(j);
            if (!isVowel(ch)) { // 모음이 아니다
               count++;
            }
         }
         if (count == 4) // 연속된 4개면 규칙에 위반
            return true;
      }
      return false;
   }

   // 모음이 4개이상 연속으로 오는지 확인
   static boolean checkvowel(String word) {
      for (int i = 0; i <= word.length() - 4; i++) {
         int count = 0;
         for (int j = i; j < i + 4; j++) {
            char ch = word.charAt(j);
            if (isVowel(ch)) {
               count++;
            }
         }
         if (count == 4)
            return true;
      }
      return false;
   }

   static boolean isVowel(char ch) {
      return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
   }

}