package ex7.FitnessCenterMemberManagingProgram;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MemberRepository {

  static List<Object> memberArr = new ArrayList<>();
  protected static final HashSet<String> emailArr = new HashSet<String>();

  public void removeMember(String email) {
    if (isEmailExist(email)) {
      memberArr.remove(memberArr.size() - 1);
    }
  }

  public boolean isEmailExist(String email) {
    if (emailArr.contains(email)) {
      return true;
    }
    return false;
  }

  public MemberRepository(String email, String name, int age) {
    Object[] memberInfo = new Object[3];
    memberInfo[0] = email;
    memberInfo[1] = name;
    memberInfo[2] = age;
    memberArr.add(memberInfo);
  }

  protected static void print(int index) {
    Object[] memberInfo = (Object[]) memberArr.get(index);
    String email = (String) memberInfo[0];
    String name = (String) memberInfo[1];
    int age = (int) memberInfo[2];

    System.out.println(name + "님의 " + "이메일은 " + email + "이고, " + "나이는 " + age + "입니다.");
    System.out.println();
  }
}
