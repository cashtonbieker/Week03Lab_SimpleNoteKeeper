/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import domain.Note;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cashton
 */
public class NoteServlet extends HttpServlet {

    Note note = new Note(); 
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String edit = request.getParameter("edit"); 
        
        
        //Read the file
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br = new BufferedReader (new FileReader(new File (path)));
        
        //Set attributes to lines that are read
        String title = br.readLine();
        String content = br.readLine();
        
        //Set note parameters
        note.setTitle(title);
        note.setContent(content);
        
        //If the edit link is not clicked keep them on the home page
        if (edit == null){
            
        //Push the new attributes to the jsp
        request.setAttribute("title", note.getTitle());
        request.setAttribute("content", note.getContent());
            
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
              
        }
        
        //If the edit link is clicked send them to the edit page
        if (edit != null){
        
        request.setAttribute("title", note.getTitle());
        request.setAttribute("content", note.getContent());
            
        getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                .forward(request, response);
        }
        
        //Close the reader
        br.close();
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Open file path
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        //Open I/O
        BufferedReader br = new BufferedReader (new FileReader(new File (path)));
        PrintWriter pw = new PrintWriter (new BufferedWriter(new FileWriter (path, false)));
       
        //Set attributes to the current value of the inputs
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        
        //Set note parameters
        note.setTitle(title);
        note.setContent(content);
        
        //Print the edited note to the note.txt file
        pw.println(note.getTitle());
        pw.println(note.getContent());
        
        //Close the writer
        pw.close();
        
        //Set attributes to the new lines in the note.txt file
        title = br.readLine();
        content = br.readLine();
        
        //Set the new note parameters
        note.setTitle(title);
        note.setContent(content);
        
        //Close the file reader
        br.close();
        
        //Push the new attributes to the jsp
        request.setAttribute("title", note.getTitle());
        request.setAttribute("content", note.getContent());
        
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
    }

}
