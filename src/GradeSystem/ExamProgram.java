package GradeSystem;

import java.util.Arrays;
import java.util.Scanner;

public class ExamProgram {

  private final int[] GradeTable = new int[3];
  int index = -1;

  private int yearInput() {
    System.out.println("몇 기인지 입력해주세요.");
    Scanner sc = new Scanner(System.in);
    String num = sc.nextLine();
    int res = this.typeCheck(num);
    if (res == -1) {
      return gradeInput();
    }
    return res;
  }

  private int gradeInput() {
    Scanner sc = new Scanner(System.in);
    String num = sc.nextLine();
    int res = this.typeCheck(num);
    if (res == -1) {
      return gradeInput();
    }
    index += 1;
    GradeTable[index] = res;
    return res;
  }

  private void totalGradeInput() {
    System.out.println("HTML 과목 점수를 입력해주세요.");
    gradeInput();
    System.out.println("CSS 과목 점수를 입력해주세요.");
    gradeInput();
    System.out.println("Javascript 과목 점수를 입력해주세요.");
    gradeInput();
  }

  private int typeCheck(String num) {
    try {
      int flag = Integer.parseInt(num);
      if (flag < 0) {
        System.out.println("자연수를 입력해주세요.");
        return -1;
      }
      return flag;
    } catch (NumberFormatException e) {
      System.out.println("자연수를 입력해주세요.");
      return -1;
    }
  }

  private double getAverage() {
    int totalGrade = 0;
    for (int i = 0; i < index + 1; i++) {
      totalGrade += GradeTable[i];
    }
    return (double) totalGrade / (index + 1);
  }

  private int getMin(int[] gradeTable) {
    int min = Integer.MAX_VALUE;
    for (int grade : gradeTable) {
      if (min >= grade) {
        min = grade;
      }
    }
    return min;
  }

  private int getMid(int[] gradeTable) {
    Arrays.sort(gradeTable);
    int length = gradeTable.length;
    int midIndex = length / 2;
    return gradeTable[midIndex];
  }

  private int getMax(int[] gradeTable) {
    int max = Integer.MIN_VALUE;
    for (int grade : gradeTable) {
      if (max < grade) {
        max = grade;
      }
    }
    return max;
  }

  public void printPassOrFail(int number, int maxGrade, int midGrade, double averageScore) {
    if (maxGrade == 100 && midGrade == 100) {
      System.out.println("합격입니다.");
    } else if ((number == 1 || number == 2) && (averageScore >= 60)) {
      System.out.println("합격입니다.");
    } else if ((number == 3) && (averageScore >= 70)) {
      System.out.println("합격입니다.");
    } else {
      System.out.println("불합격입니다.");
    }
  }

  public void printMaxMinAverageGrade(int maxGrade, int minGrade, double average) {
    System.out.printf("전체 과목 중 최고점은 %d점입니다.\n", maxGrade);
    System.out.printf("전체 과목 중 최저점은 %d점입니다.\n", minGrade);
    if (average == (int) average) {
      System.out.printf("전체 과목의 평균은 %.1f입니다.", average);
    } else {
      System.out.printf("전체 과목의 평균은 %.13f입니다.", average);
    }
  }

  private void printFinalStatus(int number, double average) {
    int maxGrade = getMax(GradeTable);
    int midGrade = getMid(GradeTable);
    int minGrade = getMin(GradeTable);
    printPassOrFail(number, maxGrade, midGrade, average);
    printMaxMinAverageGrade(maxGrade, minGrade, average);
  }

  protected void execute() {
    int number = yearInput();
    totalGradeInput();
    double average = getAverage();
    printFinalStatus(number, average);
  }
}
