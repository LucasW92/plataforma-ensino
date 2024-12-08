package application;

import entities.Lesson;
import entities.Task;
import entities.Video;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Lesson> lessons = new ArrayList<>();

        System.out.print("Quantas aulas tem o curso? ");
        int lessonsQuantity = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= lessonsQuantity; i++) {

            System.out.printf("Dados da %da aula:\n", i);
            System.out.print("Conteúdo ou tarefa (c/t)? ");
            char lessonType = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Título: ");
            String lessonTitle = sc.nextLine();

            if (lessonType == 'c') {

                System.out.print("URL do vídeo: ");
                String lessonUrl = sc.nextLine();
                System.out.print("Duração em segundos: ");
                int lessonDuration = sc.nextInt();

                lessons.add(new Video(lessonTitle, lessonUrl, lessonDuration));
            } else {

                System.out.print("Descrição: ");
                String lessonDescription = sc.nextLine();
                System.out.print("Quantidade de questões: ");
                int lessonTasksQuantity = sc.nextInt();

                lessons.add(new Task(lessonTitle, lessonDescription, lessonTasksQuantity));
            }
        }

        int courseTotalDuration = 0;

        for (Lesson lesson : lessons) {

            courseTotalDuration += lesson.duration();

        }
        System.out.printf("\nDURAÇÃO TOTAL DO CURSO = %d segundos\n", courseTotalDuration);

        sc.close();
    }

}