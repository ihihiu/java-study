import java.util.*;

class Person{
    int id;
    int priority;
    public Person(int id, int priority){
        this.id = id;
        this.priority = priority;
    }
}

public class Main {
        public int solution(int n, int m, int[] arr) {
            int answer = 0;
            Queue<Person> Q = new LinkedList<>();
            for (int i = 0; i < n; i++){
                Q.offer(new Person(i, arr[i]));
            }
            while (!Q.isEmpty()){
                Person now = Q.poll();
                boolean flag = true;
                for (Person x : Q){
                    if (x.priority > now.priority){
                        Q.offer(now);
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    answer++;
                    if (now.id == m) return answer;
                }

            }

            return answer;
           }


        public static void main(String[] args) {
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            int n = kb.nextInt();
            int m = kb.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = kb.nextInt();
            }
            System.out.println(T.solution(n, m, arr));
        }
    }
