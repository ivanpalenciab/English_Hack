
package test;

import controller.LessonController;


public class SendGradeTEst {
    public static void main(String[] args) {
        LessonController lesson = new LessonController();
        String algo = lesson.getInfo("lina",4);
        System.out.println(algo);
    }
    
}
