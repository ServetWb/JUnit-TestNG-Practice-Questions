package PracticeQuestions;

import org.testng.annotations.Test;


    /**
     * In standard Java, a class needs a main method to run.
     * However, with the JUnit framework, we can run methods independently using the @Test annotation.
     *
     * Each method annotated with @Test can be executed separately without a main method.
     */
    public class TestAnnotationsExample {

        @Test
        public void test04() {
            System.out.println("Test 4 is running");
        }

        @Test // You can disable this with @Disabled if needed
        public void test02() {
            System.out.println("Test 2 is running");
        }

        @Test
        public void test03() {
            System.out.println("Test 3 is running");
        }
    }


