package ex7.FitnessCenterMemberManagingProgram;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MemberRepository {
     static List<Object> totalInfo = new ArrayList<>();
    protected static final HashSet<String> emailArr = new HashSet<String>();

    public void removeMember(String email) {
        if (isEmailExist(email)) {
            totalInfo.remove(totalInfo.size()-1);
        }
    }

    public boolean isEmailExist(String email) {
        if (emailArr.contains(email)) {
            return true;
        }
        return false;
    }
    public MemberRepository(int number, String email, String name, int age) {
        Object[] memberInfo = new Object[4];
        memberInfo[0] = number;
        memberInfo[1] = email;
        memberInfo[2] = name;
        memberInfo[3] = age;
        totalInfo.add(memberInfo);
    }

    protected static void print() {
        System.out.println("print");
        for(int i = 0; i < totalInfo.size(); i++) {
            Object[] memberInfo = (Object[]) totalInfo.get(i);
            int number = (int) memberInfo[0];
            String email = (String) memberInfo[1];
            String name = (String) memberInfo[2];
            int age = (int) memberInfo[3];

            System.out.println("Member " + (i+1) + " info:");
            System.out.println("Number: " + number);
            System.out.println("Email: " + email);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println();
        }
    }
}
