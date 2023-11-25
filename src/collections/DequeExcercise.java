package collections;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class DequeExcercise {
    public static void main(String[] args){
        Deque<Integer> deq = new LinkedList<>();
        deq.offer(1); // adiciona un elemento a la derecha(a la cola)
        deq.add(2); // adiciona un elemento a la derecha(a la cola)
        deq.push(3); // adiciona un elemento a la izquierda(a la pila)
        deq.push(4); // adiciona un elemento a la izquierda(a la pila)
        System.out.println(deq);
        System.out.println(deq.pop());// remueve de la izquierda y retorna el elemento
        System.out.println(deq.remove());// remueve de la izquierda y retorna el elemento
        System.out.println(deq.poll());// remueve de la izquierda y retorna el elemento
        System.out.println(deq.peek());// retorna el elemento que está al extremo de la izquierda
        System.out.println(deq.element());// Al igual que peek retorna el elemento que está al extremo de la izquierda
        System.out.println("Está vacía: " + deq.isEmpty());// retorna el elemento de la queue
    }

    /*[4, 3, 1, 2]
        4
        3
        1
        2
        2
        Está vacía: false*/

    /*public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);
        Deque<Character> stack;
        while (sc.hasNext()) {
            String input=sc.next();
            stack = new LinkedList<>();
            if(input.isEmpty()){
                System.out.println("true");
            } else {
                for (int i = 0; i < input.length(); i++) {
                    if(stack.isEmpty()){
                        stack.push(input.charAt(i++));
                    }
                    if(i<input.length()){
                        if(stack.peek()=='(' && input.charAt(i)==')' ||
                                stack.peek()=='[' && input.charAt(i)==']' ||
                                stack.peek()=='{' && input.charAt(i)=='}'){
                            stack.pop();
                        } else {
                            stack.push(input.charAt(i));
                        }
                    }
                }
                System.out.println(stack.isEmpty()?"true":"false");
            }
            //Complete the code
        }

    }*/
}