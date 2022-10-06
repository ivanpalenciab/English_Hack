
package controller;


public interface ILessonController {
    public String sendGrade(String username, int lessonId,boolean finished , double grade);
    public String getInfo(String username, int lessonId );
    
}
