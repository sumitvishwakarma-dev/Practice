public class Parent {

        Parent() {
            this("constructorP");
            System.out.println("parent");
        }

        Parent(String s) {
            System.out.println(s+" :::: ");
        }
    }

    class Child extends Parent {


        Child() {

            this("constructor child");
            System.out.println("CJ");
        }

        Child(String s) {
            System.out.println(s+" ::C: ");
        }


        public static void main(String[] args) {
            Child ch = new Child();
        }
    }

