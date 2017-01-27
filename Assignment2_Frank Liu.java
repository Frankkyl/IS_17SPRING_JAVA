/**
 * Created by Rose on 1/21/17.
 * Assignment for your lecture 2. Please finish all the questions under
 * 'Assignment'. Assignment 2 includes 3 interview prepare questions. They
 * are similar to what you will meet during your technical interviews.Write some tests as practice.
 * Please try to think the extra credit question. The deadline of this assignment is 01/26/2017 23:59 PST.
 * Please feel free to contact me for any questions.
 */

class Employee {
    String name;
    int age;
    Gender gender;
    double salary;// salary per month


    public Employee(String name, int age, Gender gender, double salary) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //FL's code:
    //New added method()
    public void raiseSalary(double byPercent) {
        //Q:it's be updated as "double" when java run.
        double raiseSalary;
        //byPercent = 300;      
        raiseSalary = salary * byPercent / 100; 
        
    }   
    
}

enum Gender {
    MALE,
    FEMALE;
}


public class Assignment {
    // Assignment
    
    /**
     * Write a method to calculate the Social Security Tax of an employee and print it.
     * If the salary is less than or equal to 8900, the Social Security Tax is 6.2% of the salary.
     * If the salary is more than 8900, the Social Security Tax is 6.2% of 106,800.
     */
    /****
    public static void main(String[] args) {
    
    Employee ee1 = new Employee("Ruby",25,Gender.FEMALE,5000);
    Employee ee2 = new Employee("Frank",31,Gender.MALE,12000);
    
    System.out.println(socialSecurityTax(ee1));
    System.out.println(socialSecurityTax(ee2));
    }
     ****/
    public double socialSecurityTax(Employee employee) {
        //write your code here
        //FL's code1:
        //Q:Why it's be added with "static" (public static double socialSecurityTax(Employee employee), when I try to run it?
        //Q:What's the different to run the app.java by "click the green triangle button" and "right click to 'run as'"?
        double socialSecurityTax1;
        double s = employee.salary;
        
            if (s <= 8900) {
                socialSecurityTax1 = s * 0.062;
            } else {
                socialSecurityTax1 = 106800 * 0.062;
            }
            
        //Output is a string, not a number. 
        System.out.println("The Social Security Tax for " + employee.name +", is $" + String.format("%.2f", socialSecurityTax1) +"."); 
        //Q:do we have any code run if we have something after the line "return"?
        return socialSecurityTax1;
        
        /****    
        //FL's code2:
        //Try to make this easy for future maintenance.
        //Q:Why this show 'System.out.println(socialSecurityTax(ee1))' result as 'float'? 
        double socialSecurityTax2;
        double base;
        float rate;
        double cal;
        double ceiling;
        double s1;
        
        s1 = employee.salary;
        rate = 0.062f;
        cal = 8900;
        ceiling = 106800;
        
        if (s1 <= cal) {
            base = s1;
        } else {
            base = ceiling;
        }
        
        socialSecurityTax2 = base * rate;
        //Output as a number.       
        //Q: Do we really have a case that even we set up variant as double, but when the code run, we have more after the "."      
        //If we have a specific rule to setup rounding for every steps during the calculation, we could also do that.
        System.out.println("The Social Security Tax for " + employee.name +", is $" + (double)(Math.round(socialSecurityTax2*100)/100.0) +".");  
        
        return socialSecurityTax2;
        ****/
    }
    
    /**
     * Write a method to calculate an employee's contribution for insurance coverage and print it.
     * Amount of deduction is computed as follows:
     * If the employee is under 35, rate is 3% of salary; if the employee is between 35 and 50(inclusive), rate is 4% of salary;
     * If the employee is between 50 and 60(exclusive), rate is 5% of salary; If the employee is above 60, rate is 6% of salary.
     */
    public double insuranceCoverage(Employee employee) {
        //write your code here
        //FL's code1:
        //from big to small
        //Mark:Same with SST, it's be added with "static", and run as 'float' in println() for code2 and code3.
        double insuranceCoverage1;
        double a1 = employee.age;
        double s1 = employee.salary;
        
        if (a1 > 60) {
            insuranceCoverage1 = s1 * 0.06;
        } else if (a1 > 50) {
            insuranceCoverage1 = s1 * 0.05;
        } else if (a1 >35 ) {
            insuranceCoverage1 = s1 * 0.04;
        } else {
            insuranceCoverage1 = s1 * 0.03;
        }
        System.out.println("Employee, " + employee.name + ", his/her current contribution for insurance coverage is $" + (double)(Math.round(insuranceCoverage1*100)/100.0) + ".");
        return insuranceCoverage1;
        
        /****
        //FL's code2:
        
        double insuranceCoverage2;
        double a2 = employee.age;
        double s2 = employee.salary;
        float rate;
        
        if (a2 > 60) {
            rate = 0.06f;
        } else if (a2 > 50) {
            rate = 0.05f;
        } else if (a2 >35) {
            rate = 0.04f;
        } else {
            rate = 0.03f;
        }
        insuranceCoverage2 = s2 * rate;
        System.out.println("Employee, " + employee.name + ", his/her current contribution for insurance coverage is $" + (double)(Math.round(insuranceCoverage2*100)/100.0) + ".");     
        return insuranceCoverage2;
        
        //FL's code3:
        // from small to big
        double insuranceCoverage3;
        double a3 = employee.age;
        double s3 = employee.salary;
        float rate;
        
        if (a3 < 35) {
            rate = 0.03f;
        } else if (a3 > 35 && a3 <=50) {
            rate = 0.04f;
        } else if (a3 >50 && a3 <= 60) {
            rate = 0.05f;
        } else {
            rate = 0.06f;
        }
        insuranceCoverage3 = s3 * rate;
        System.out.println("Employee, " + employee.name + ", his/her current contribution for insurance coverage is $" + (double)(Math.round(insuranceCoverage3*100)/100.0) + ".");     
        return insuranceCoverage3;
        ****/
    }
    /**
     * Write a method to sort three employees' salary from low to high, and then print their name in order.
     * For example, Alice's salary is 1000, John's salary is 500, Jenny's salary is 1200, you should print:
     * John Alice Jenny
     */
    public static void sortSalary(Employee e1, Employee e2, Employee e3) {
        //write your code here
        //FL's code1:

        if (e1.salary > Math.max(e2.salary,e3.salary)) {
            if (e2.salary < e3.salary) {
                System.out.println("Show employee's name by their salary from low to high: " + e2.name + " " + e3.name + " " + e1.name);
            } else {
                System.out.println("Show employee's name by their salary from low to high: " + e3.name + " " + e2.name + " " + e1.name);
            }
        }else {
            if (e2.salary < e3.salary) {
                if (e1.salary < e2.salary) {
                    System.out.println("Show employee's name by their salary from low to high: " + e1.name + " " + e2.name + " " + e3.name);
                } else {
                    System.out.println("Show employee's name by their salary from low to high: " + e2.name + " " + e1.name + " " + e3.name);
                }
            } else if (e1.salary < e3.salary) {
                System.out.println("Show employee's name by their salary from low to high: " + e1.name + " " + e3.name + " " + e2.name);                
            } else {
                System.out.println("Show employee's name by their salary from low to high: " + e3.name + " " + e1.name + " " + e2.name);
            }
        }   
    
        //FL's code2:
        //Q:Try to create another class to match back from salary to name, but failed; and there should be another easy way to mapping. Just keep this open and leave it now.
        /****
        double max1;
        double max2;
        double min1;
        double min2;
        double sum = e1.salary + e2.salary + e3.salary;
        double mid = sum - max1 - min2;
        
        max1 = Math.max(e1.salary,e2.salary);
        max2 = Math.max(max1, e3.salary);
        min1 = Math.min(e1.salary,e2.salary);
        min2 = Math.min(min1, e3.salary);
        ****/
    }
    /**
     * Write a method to raise an employee's salary to three times of his/her original salary.
     * Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
     * Do not change the input of this method.
     * Try to add a new method in Employee class: public void raiseSalary(double byPercent)
     */
    public void tripleSalary(Employee employee) {
        //write your code here
        //FL's code:    
        //Mark:Same with SST, it's be added with "static"
        double newSalary = employee.raiseSalary(300);
        
        System.out.println("The Employee, " + employee.name + ", his new salary, which is tripled, is $ " + newSalary + ".");
        
    }
  //Interview prepare questions

    /**
     * Write a method to determine whether a number is prime
     */
    public boolean isPrime(int n) {
        //write your code here
        //FL's code1:
        /*****
         *  round down:Math.floor(3.5)=3
            round:Math.rint(3.5)=4
            round up:Math.ceil(3.1)=4 
         *****/
        
        for (int i = 2; i <= n; i = i + 1) {

            // FL's code2: if (n%i != 0 ); 
            if (Math.floor(n/i) - Math.ceil(n/i) != 0){ 
                return false;
            } 
            return true;
        }       
        //Q:Why I can't put the "return true" under the {} of "for"?
        return false;
                
    }
    /**
     * Given a non-negative integer n, repeatedly add all its digits until the
     * result has only one digit. For example: Given n = 38, the process is
     * like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
     */
    public int addDigits(int n) {
        //write your code here
        //FL's code1:
        int len = String.valueOf(n).length();
        int val;
        
        int sum = 0;
        for (int i = 1; i <= len; i = i + 1) {

            val = Integer.parseInt(String.valueOf(n).substring(0, i))   ;
            sum = sum + val;
        }
        System.out.println("For " + n + ", the sum of all its digits is: " + sum + ".");
        return sum;
    }
    /**
     * Write a program to check whether a given number is an ugly number. Ugly
     * numbers are positive numbers whose prime factors only include 2, 3, 5.
     * For example, 6, 8 are ugly, while 14 is not ugly since it includes
     * another prime factor 7. Note that 1 is typically treated as an ugly
     * number.
     */
    public boolean isUgly(int n) {
        //write your code here
        //FL's code:
        /**** wrong code
        for (int i = 0; i < n; i = i + 1) {
        
            if (i != 2 && i != 3 && i != 5) {
                if (n%i == 0) {
                    return false;
                }
            }
        }
        return true;
        ****/
        // "/=", while
        //Q:Why there is no "{}"?
        if (n == 1) return true;
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;
        return true;
        
    }
    //Extra credit

    /**
     * I have written some code below. What I want is to swap two Employee objects.
     * One is Jenny and one is John. But after running it, I got the result below:
     * Before: a=Jenny
     * Before: b=John
     * After: a=Jenny
     * After: b=John
     * There is no change after swap()! Do you know the reason why my swap failed?
     * Write your understanding of the reason and explain it.
     */
    /*
     write your understanding here.
     **FL's answer: It seems when u do the swap, u swap the name of two objects name not objects? (wrong answer)
     **note:http://www.javaworld.com/article/2077424/learn-java/does-java-pass-by-reference-or-pass-by-value.html
    */
    public static void main(String[] args) {
        Employee a = new Employee("Jenny", 20, Gender.FEMALE, 2000);
        Employee b = new Employee("John", 30, Gender.MALE, 2500);
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        swap(a, b);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());
    }

    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
    }
}
      

    
    

    


    

