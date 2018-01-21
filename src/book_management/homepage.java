
package book_management;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;


/*......................logIn page....................*/
public class homepage extends JFrame
{
    int i=0;
    private String s1,s;
    private JPanel jpn_home,jpn_registration,jpn_book,jpn_member,jp_sex1,jpn_memberEnty,jpn_bookenty,jpn_book_show;
    private JButton jbn1,jb_bookInsert,jb_bookDelete,jb_bookSearch,jb_book_save,jb_book_search,jb_book_input;
    private JComboBox ct, dpt, edt;
    private JButton jb_book_delete_input,jb_book_delete,jb_home,jb_registration,jb_book,jb_member,jb_reg_save,jb_delete_member,jb_update_member;
    private JLabel l_login,l1,l2,l_home,l_registration,l_book,l_member,l_book_search,l_book_insert,l_book_delete;
    private JLabel l_MemberID,l_StudentID,l_Department,l_Sex,l_StudentName,l_Session;
    private JLabel l_Email,l_parmamentAddr,l_CurrentAddr,l_ContractNo,l_book_search_show,l_book_search_input;
    private JLabel l_book_id,l_book_name,l_book_categary,l_book_department,l_book_author,l_book_edition,l_book_release_year,l_book_number,l_book_price;
    private JTextField jt_book_delete2,jt_MemberID,jt_StudentID,jt_Department,jt_StudentName,jt_Session,jt_delete_member;
    private JTextField jta1,jt_Email,jt_parmamentAddr,jt_CurrentAddr,jt_ContractNo,jt_book_search;
    private JTextField jt_book_delete,jt_book_id,jt_book_name,jt_book_Author,jt_book_Release_Year,jt_book_Price,jt_book_number;
    private JRadioButton M, F;
    //private  String column[]={"Book_Id", "Book_Name", "Category", "Author", "Available Books"};
    private String category_course[]={"Select Category", "Arts & Photogrphy","Horror and Thriller", "Computer Programming","Comics","Travel & language","Literature","Engineering & Technology","Science Fiction","Mathematics","Physics","Sports & Games","Romance Novels","Megazine","Others"};
    private String dept_course[] = {"Select Department", "N/A", "CSE", "ICT", "TE", "ESRM", "BGE", "CPS", "FTNS", "PHY", "STA", "CHE","MATH", "ECO", "ENG", "SCO"};
    private String edition_course[] = {"Select Edition", "1st Edition", "2nd Edition","3rd Edition","4th Edition","5th Edition","6th Edition","7th Edition","8th Edition","9th Edition","10th Edition","11th Edition","12th Edition","13th Edition","14th Edition","15th Edition"};
   
   // private JTextArea jta1,jta2;
    private JTextArea jta_memberPage,jta_bookenty,jta_book_show,jta_status_show;
    private JPasswordField jta2;    
    private JScrollPane jscrolbar_member1,jscolbar_book,jscrolbar_book_search,jscrolbar_ststus;
    ImageIcon image_login = new ImageIcon(getClass().getResource("images/Login.jpg"));
    ImageIcon image_home = new ImageIcon(getClass().getResource("images/Home.jpg"));
    ImageIcon image_registration = new ImageIcon(getClass().getResource("images/Registration.jpg"));
    ImageIcon image_book = new ImageIcon(getClass().getResource("images/Book_page.jpg"));
    ImageIcon image_member = new ImageIcon(getClass().getResource("images/Member.jpg"));
    ImageIcon image_AssignBook = new ImageIcon(getClass().getResource("images/Assign_book.jpg"));
    ImageIcon image_Status = new ImageIcon(getClass().getResource("images/Status_2.jpg"));
    ImageIcon image_MyAccount = new ImageIcon(getClass().getResource("images/My_account.jpg"));
    //private ImageIcon image_login = new ImageIcon("images/Login.jpg");
 //   private ImageIcon image_home = new ImageIcon("images/Home.jpg");
   // private ImageIcon image_registration=new ImageIcon("images/Registration.jpg");
    //private ImageIcon image_book=new ImageIcon("images/Book_page.jpg");
 //   private ImageIcon image_member=new ImageIcon("images/Member.jpg");
  //  private ImageIcon image_AssignBook=new ImageIcon("images/Assign_book.jpg");
   // private ImageIcon image_Status=new ImageIcon("images/Status_2.jpg");
   // private ImageIcon image_MyAccount=new ImageIcon("images/My_account.jpg");
    private JPanel jpn_AssignBook,jpn_Status,jpn_MyAccount,jpn_ststus_show;
    private JLabel l_AssignBook_memberId2,l_AssignBook_BookId2,l_AssingBook,l_Status,l_MyAccount,l_AssignBook_memberId,l_AssignBook_BookId,l_AssignBook_Date;
    private JButton jb_assign,jb_assigndelete,jb_status_show,jb_return_back,jb_return_done,jb_AssingBook,jb_Status,jb_MyAccount,jb_lendBook,jb_returnBook,jb_lend_back,jb_lend_done;
    private JLabel l_lendBook,l_returnBook,l_AssignBook_exDate,l_assignresult,l_assigndeleteresult;
    private JTextField jt_AssignBook_memberId,jt_AssignBook_BookId,jt_AssignBook_Date,jt_AssignBook_exDate;
    private JTextField jt_AssignBook_memberId2,jt_AssignBook_BookId2,jt_AssignBook_Date2;
    private JLabel l_oldUserName,l_oldUserPassword,l_newUserName,l_newUserPassword;
    private JTextField jt_oldUserName,jt_oldUserPassword,jt_newUserName,jt_newUserPassword;
    private JButton myaccount_done;
    public homepage() 
    {
        setBounds(180, 10, 1000,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        /*.............create Panel object.............*/
        jpn_registration=new JPanel();
        jpn_registration.setBounds(0, 0, 1000, 700);
                
        jpn_home=new JPanel();
        jpn_home.setBounds(0, 0, 1000, 700);
        
        jpn_book=new JPanel();
        jpn_book.setBounds(0, 0, 1000, 700);
        
        jpn_member=new JPanel();
        jpn_member.setBounds(0, 0, 1000, 700);
        
        jpn_AssignBook=new JPanel();
        jpn_AssignBook.setBounds(0, 0, 1000, 700);
        
        jpn_Status=new JPanel();
        jpn_Status.setBounds(0, 0, 1000, 700);
        
        jpn_MyAccount=new JPanel();
        jpn_MyAccount.setBounds(0, 0, 1000, 700);
        
        jpn_registration.setLayout(null);
        jpn_book.setLayout(null);
        jpn_home.setLayout(null);
        jpn_member.setLayout(null);
        jpn_AssignBook.setLayout(null);
        jpn_Status.setLayout(null);
        jpn_MyAccount.setLayout(null);
        
        /*..........end Panel object .........*/
        
        
        /*...........Label object create.........*/
        l_login = new JLabel(image_login);
        
        l_home=new JLabel(image_home);
        l_home.setSize(1000, 700);
        
        l_registration=new JLabel(image_registration);
        l_registration.setSize(1000, 700);
        
        l_book=new JLabel(image_book);
        l_book.setSize(1000, 700);
        
        l_member=new JLabel(image_member);
        l_member.setSize(1000, 700);
        
        l_book_search=new JLabel(image_book);
        l_book_search.setSize(1000, 700);
        
        l_book_insert=new JLabel(image_book);
        l_book_insert.setSize(1000, 700);
        
        l_book_delete=new JLabel(image_book);
        l_book_delete.setSize(1000, 700);
       
         l_AssingBook=new JLabel(image_AssignBook);
        l_AssingBook.setSize(1000, 700);
        
         l_lendBook=new JLabel(image_AssignBook);
        l_lendBook.setSize(1000, 700);
        
         l_returnBook=new JLabel(image_AssignBook);
        l_returnBook.setSize(1000, 700);
        
         l_Status=new JLabel(image_Status);
        l_Status.setSize(1000, 700);
        
         l_MyAccount=new JLabel(image_MyAccount);
        l_MyAccount.setSize(1000, 700);
        
        l_home.setLayout(null);
        l_registration.setLayout(null);
        l_book.setLayout(null);
        l_member.setLayout(null);
        l_book_search.setLayout(null);
        l_book_insert.setLayout(null);
        l_book_delete.setLayout(null);
        l_AssingBook.setLayout(null);
        l_Status.setLayout(null);
        l_MyAccount.setLayout(null);
        l_lendBook.setLayout(null);
        l_returnBook.setLayout(null);
        setContentPane(l_login);
        /*................Label object end..........*/
               
        
        /*............home label...........*/
        jb_home = new JButton("Home");
        jb_home.setBounds(30,50,150,30);

        jb_registration =  new JButton("Registration");
        jb_registration.setBounds(30,120,150,30);

        jb_book = new JButton("Book");
        jb_book.setBounds(30, 190, 150, 30);


        jb_member = new JButton("Member");
         jb_member.setBounds(30, 260, 150, 30);
        
         jb_AssingBook = new JButton("Assign Book");
         jb_AssingBook.setBounds(30, 330, 150, 30);
         
         jb_Status = new JButton("Status");
         jb_Status.setBounds(30, 400, 150, 30);
         
         jb_MyAccount = new JButton("My Account");
         jb_MyAccount.setBounds(30, 470, 150, 30);
          
        l_home.add(jb_home);
        l_home.add(jb_registration);
        l_home.add(jb_book);
        l_home.add(jb_member);
        l_home.add(jb_AssingBook);
        l_home.add(jb_Status);
        l_home.add(jb_MyAccount);
        
       
       
        /*..............end home label............*/
       
        
        /*........registration page............*/
        
        
        l_MemberID = new JLabel("Member Id: ");  
        l_MemberID.setFont(new Font("Arial", Font.BOLD, 20));
        l_MemberID.setForeground(Color.GREEN);
        l_MemberID.setBounds(450, 100, 250, 30);
        l_registration.add(l_MemberID);
        
        l_StudentID = new JLabel("Student ID: ");
        l_StudentID.setFont(new Font("Arial", Font.BOLD, 20));
        l_StudentID.setForeground(Color.GREEN);
        l_StudentID.setBounds(450, 150, 250, 30);
        l_registration.add(l_StudentID);
        
        l_StudentName = new JLabel("Student Name: ");
        l_StudentName.setFont(new Font("Arial", Font.BOLD, 20));
        l_StudentName.setForeground(Color.GREEN);
        l_StudentName.setBounds(450, 200, 250, 30);
        l_registration.add(l_StudentName);
        
        l_Department = new JLabel("Department: ");
        l_Department.setFont(new Font("Arial", Font.BOLD, 20));
        l_Department.setForeground(Color.GREEN);
        l_Department.setBounds(450, 250, 250, 30);
        l_registration.add(l_Department);
        
        l_Session = new JLabel("Session: ");
        l_Session.setFont(new Font("Arial", Font.BOLD, 20));
        l_Session.setForeground(Color.GREEN);
        l_Session.setBounds(450, 300, 250, 30);
        l_registration.add(l_Session);
        
        l_Sex = new JLabel("Sex: ");
        l_Sex.setFont(new Font("Arial", Font.BOLD, 20));
        l_Sex.setForeground(Color.GREEN);
        l_Sex.setBounds(450, 350, 250, 30);
        l_registration.add(l_Sex);
        
        l_CurrentAddr = new JLabel("Current Addr: ");
        l_CurrentAddr.setFont(new Font("Arial", Font.BOLD, 20));
        l_CurrentAddr.setForeground(Color.GREEN);
        l_CurrentAddr.setBounds(450, 400, 250, 30);
        l_registration.add(l_CurrentAddr);
        
        l_parmamentAddr = new JLabel("Parmanent Addr: ");
        l_parmamentAddr.setFont(new Font("Arial", Font.BOLD, 20));
        l_parmamentAddr.setForeground(Color.GREEN);
        l_parmamentAddr.setBounds(450, 450, 250, 30);
        l_registration.add(l_parmamentAddr);
        
        l_ContractNo = new JLabel("Contract No: ");
        l_ContractNo.setFont(new Font("Arial", Font.BOLD, 20));
        l_ContractNo.setForeground(Color.GREEN);
        l_ContractNo.setBounds(450, 500, 250, 30);
        l_registration.add(l_ContractNo);
        
        jt_MemberID=new JTextField();
        jt_MemberID.setFont(new Font("Arial", Font.BOLD, 20));
        jt_MemberID.setBounds(620, 100, 250, 30);
        l_registration.add(jt_MemberID);
        
        jt_StudentID=new JTextField();
        jt_StudentID.setFont(new Font("Arial", Font.BOLD, 20));
        jt_StudentID.setBounds(620, 150, 250, 30);
        l_registration.add(jt_StudentID);
        
        jt_StudentName=new JTextField();
        jt_StudentName.setFont(new Font("Arial", Font.BOLD, 20));
        jt_StudentName.setBounds(620, 200, 250, 30);
        l_registration.add(jt_StudentName);   
        
        jt_Department=new JTextField();
        jt_Department.setFont(new Font("Arial", Font.BOLD, 20));
        jt_Department.setBounds(620, 250, 250, 30);
        l_registration.add(jt_Department);    
        
        jt_Session=new JTextField();
        jt_Session.setFont(new Font("Arial", Font.BOLD, 20));
        jt_Session.setBounds(620, 300, 250, 30);
        l_registration.add(jt_Session);        
        //jt.setBounds(560, 350, 200, 30);
        jp_sex1=new JPanel();
        jp_sex1.setBounds(620, 350, 250, 30);
        jp_sex1.setFont(new Font("Arial", Font.BOLD, 20));
        l_registration.add(jp_sex1);        
        
        jt_CurrentAddr=new JTextField();
        jt_CurrentAddr.setFont(new Font("Arial", Font.BOLD, 20));
        jt_CurrentAddr.setBounds(620, 400, 250, 30);
        l_registration.add(jt_CurrentAddr);   
        
        jt_parmamentAddr=new JTextField();
        jt_parmamentAddr.setFont(new Font("Arial", Font.BOLD, 20));
        jt_parmamentAddr.setBounds(620, 450, 250, 30);
        l_registration.add(jt_parmamentAddr);        
        
        jt_ContractNo=new JTextField();
        jt_ContractNo.setFont(new Font("Arial", Font.BOLD, 20));
        jt_ContractNo.setBounds(620, 500, 250, 30);
        l_registration.add(jt_ContractNo);
        
        
        ButtonGroup buttonGroup = new ButtonGroup();
        M = new JRadioButton("Male");
        M.setFont(new Font("Arial", Font.BOLD, 17));
        buttonGroup.add(M);
        jp_sex1.add(M);

        F = new JRadioButton("Female");
        F.setFont(new Font("Arial", Font.BOLD, 17));
        buttonGroup.add(F);
        jp_sex1.add(F);
        M.setSelected(true);
        
        jb_reg_save=new JButton("Save");
        jb_reg_save.setBounds(700, 550, 100, 50);
        jb_reg_save.setFont(new Font("Arial", Font.BOLD, 25));       
        l_registration.add(jb_reg_save);
        
        
        /*..............end registration page..............*/
        
        /*.............member page....................*/
        jpn_memberEnty=new JPanel();        
        jpn_memberEnty.setBounds(300, 100, 650, 445);
        
        jta_memberPage=new JTextArea(27, 57 );
        jta_memberPage.setEditable ( false );
       // jta_memberPage.setBounds(300, 100, 650, 350);
                
        jscrolbar_member1=new JScrollPane(jta_memberPage);        
        jscrolbar_member1.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );        
        
        //jpn_memberEnty.add(jta_memberPage);
         jpn_memberEnty.add(jscrolbar_member1);
        l_member.add(jpn_memberEnty);
        
        jb_delete_member=new JButton("delete");
        jb_delete_member.setBounds(470, 560, 100, 50);
        l_member.add(jb_delete_member);
        jt_delete_member=new JTextField();
        jt_delete_member.setBounds(600, 570, 150, 20);
        l_member.add(jt_delete_member);
       // jta_memberPage.setFont(new Font("Segoe Script", Font.BOLD, 20));
        /*.............end member page...................*/
        
        /*.........................
         * ..........................
         * ...............................        
         *.......................................book...........*/
        
        jpn_bookenty=new JPanel();        
        jpn_bookenty.setBounds(300, 100, 650, 445);
        
        jta_bookenty=new JTextArea(27, 57 );
        jta_bookenty.setEditable ( false );
       // jta_memberPage.setBounds(300, 100, 650, 350);
                
        jscolbar_book=new JScrollPane(jta_bookenty);        
        jscolbar_book.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );        
        
        //jpn_memberEnty.add(jta_memberPage);
         jpn_bookenty.add(jscolbar_book);
        l_book.add(jpn_bookenty);
        jb_bookSearch=new JButton("Book Search");
        jb_bookInsert=new JButton("Book Inseart");
        jb_bookDelete=new JButton("Book Delete");
        
        jb_bookSearch.setBounds(450, 55, 150, 35);
        jb_bookInsert.setBounds(600, 55, 150, 35);
        jb_bookDelete.setBounds(750, 55, 150, 35);
        
        l_book.add(jb_bookSearch);
        l_book.add(jb_bookInsert);
        l_book.add(jb_bookDelete);
        
        /*.......................
         * ..............................Book Search...............*/
        
        /*......................
         * ...............................end book search.........*/
        jt_book_search=new JTextField();
      //  jta_book_show=new JTextArea("");
       // jta_book_show.setBackground(Color.darkGray);
        jb_book_input=new JButton("Enter Book Name");
       
        jb_book_search=new JButton("Go");
        jb_book_input.setBounds(350, 150, 160, 35);       
        jt_book_search.setBounds(540, 150, 200, 35);
        jb_book_search.setBounds(760, 150, 100, 35);
        
        
        jta_book_show=new JTextArea(9, 24 );
        jta_book_show.setEditable ( false );
        //jta_book_show.setBounds(350, 200, 510, 300);
        
        jta_book_show.setEditable ( false );
        jta_book_show.setFont(new Font("Segoe Script", Font.BOLD, 20));
        jpn_book_show=new JPanel();        
        jpn_book_show.setBounds(350, 200, 510, 305);
        jscrolbar_book_search=new JScrollPane(jta_book_show);        
        jscrolbar_book_search.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );        
        
        //jpn_memberEnty.add(jta_memberPage);
         jpn_book_show.add(jscrolbar_book_search);
         l_book_search.add(jpn_book_show);

        
        l_book_search.add(jt_book_search);
        l_book_search.add(jb_book_input);
     //   l_book_search.add(jta_book_show);
        l_book_search.add(jb_book_search);
        
        /*......................
         * ..............................book insert............*/
        
        l_book_number=new JLabel("Book ID");
        l_book_name=new JLabel("Book Name: ");
        l_book_categary=new JLabel("Category: ");
        l_book_department=new JLabel("Department : ");
        l_book_author=new JLabel("Author: ");
        l_book_edition=new JLabel("Edition: ");
        l_book_release_year=new JLabel("Release Year: ");
        l_book_price=new JLabel("Price: ");


        l_book_number.setBounds(300, 150, 150, 30);
        l_book_name.setBounds(300, 200, 150, 30);
        l_book_categary.setBounds(300, 250, 150, 30);
        l_book_department.setBounds(300, 300, 150, 30);
        l_book_author.setBounds(300, 350, 150, 30);
        l_book_edition.setBounds(300, 400, 150, 30);
        l_book_release_year.setBounds(300, 450, 150, 30);
        l_book_price.setBounds(300, 500, 150, 30);
      
        
        l_book_insert.add(l_book_number);l_book_insert.add(l_book_name);l_book_insert.add(l_book_categary);l_book_insert.add(l_book_department);l_book_insert.add(l_book_author);l_book_insert.add(l_book_edition);l_book_insert.add(l_book_release_year);l_book_insert.add(l_book_price);
       
       // jt_book_id = new JTextField(8);
        jt_book_name = new JTextField(8);
        
        jt_book_Author = new JTextField(8);
        //t5 = new JTextField(8);
        jt_book_Release_Year = new JTextField(8);
        jt_book_Price = new JTextField(8);
        jt_book_number = new JTextField(8);

        jt_book_number.setBounds(500, 150, 200, 30);
        jt_book_name.setBounds(500, 200, 200, 30);
        
        jt_book_Author.setBounds(500, 350, 200, 30);
        //t5.setBounds(500, 300, 200, 30);
        jt_book_Release_Year.setBounds(500, 450, 200, 30);
        jt_book_Price.setBounds(500, 500, 200, 30);
        

        l_book_insert.add(jt_book_number);l_book_insert.add(jt_book_name);l_book_insert.add(jt_book_Author);l_book_insert.add(jt_book_Release_Year);l_book_insert.add(jt_book_Price);
        
        ct = new JComboBox(category_course);
        ct.setBackground(Color.black);
        ct.setForeground(Color.yellow);
        ct.setBounds(500, 250, 200, 30);
        dpt = new JComboBox(dept_course);
        dpt.setBackground(Color.black);
        dpt.setForeground(Color.yellow);
        dpt.setBounds(500, 300, 200, 30);
        edt = new JComboBox(edition_course);
        edt.setBackground(Color.black);
        edt.setForeground(Color.yellow);
        edt.setBounds(500, 400, 200, 30);
        l_book_insert.add(edt);
        l_book_insert.add(dpt);
        l_book_insert.add(ct);
        
        jb_book_save = new JButton("Save");
        jb_book_save.setBounds(550, 550, 100, 40);
        l_book_insert.add(jb_book_save);
        /*......................
         * .........................end book insert.........*/
        
        
        /*...................
         * ............................book delete............*/
        jt_book_delete=new JTextField();
        jt_book_delete2=new JTextField();
       // jta_book_show.setBackground(Color.darkGray);
        jb_book_delete_input=new JButton("Enter Book ID");
       
        jb_book_delete=new JButton("delete");
        jb_book_delete_input.setBounds(350, 150, 160, 35);       
        jt_book_delete.setBounds(540, 150, 200, 35);
        jt_book_delete2.setBounds(540, 190, 200, 35);
        jb_book_delete.setBounds(760, 150, 100, 35);
        
        l_book_delete.add(jt_book_delete);
        l_book_delete.add(jt_book_delete2);
        l_book_delete.add(jb_book_delete_input);        
        l_book_delete.add(jb_book_delete);
                /*............................
         * .................................end book delete..............*/
        
        /*.................................
         * ...................
         * ...................
        
         *.................................end book..............*/
        

        
        
        
        /*......................assign book.....................*/
        
        jb_lendBook = new JButton("Lend Book");
        jb_returnBook = new JButton("Return Book");

        jb_lendBook.setBounds(450, 200, 200, 50);
        jb_returnBook.setBounds(450, 300, 200, 50);
                
        l_AssingBook.add(jb_lendBook); 
        l_AssingBook.add(jb_returnBook);

        /*...............lend book.....................*/
        
        l_AssignBook_memberId = new JLabel("Enter Member ID :");
        l_AssignBook_BookId = new JLabel("Enter Book ID   :");
        l_AssignBook_Date = new JLabel("Enter Issue Date   :");
        l_AssignBook_exDate = new JLabel("Enter Exp Date   :");
        l_assignresult=new JLabel();
        
        l_AssignBook_memberId.setBounds(300, 100, 200, 30);
        l_AssignBook_memberId.setFont(new Font("Courier New", 1, 17));
        l_AssignBook_memberId.setForeground(Color.YELLOW);
        
        l_AssignBook_BookId.setBounds(300, 150, 200, 30);
        l_AssignBook_BookId.setFont(new Font("Courier New", 1, 17));
        l_AssignBook_BookId.setForeground(Color.YELLOW);
        
        l_AssignBook_Date.setBounds(300, 200, 200, 30);
        l_AssignBook_Date.setFont(new Font("Courier New", 1, 17));
        l_AssignBook_Date.setForeground(Color.YELLOW);
        
        l_AssignBook_exDate.setBounds(300, 250, 200, 30);
        l_AssignBook_exDate.setFont(new Font("Courier New", 1, 17));
        l_AssignBook_exDate.setForeground(Color.YELLOW);
        
        l_assignresult.setBounds(300, 350, 400, 30);
        l_assignresult.setFont(new Font("Courier New", 1, 17));
        l_assignresult.setForeground(Color.YELLOW);
        
        jt_AssignBook_memberId=new JTextField(8);
        jt_AssignBook_BookId=new JTextField(8);
        jt_AssignBook_Date=new JTextField(8);
        jt_AssignBook_exDate=new JTextField(8);
        
        jt_AssignBook_memberId.setBounds(550, 100, 100, 30);
        jt_AssignBook_BookId.setBounds(550, 150, 100, 30);
        jt_AssignBook_Date.setBounds(550, 200, 100, 30);
        jt_AssignBook_exDate.setBounds(550, 250, 100, 30);
        
        jb_lend_done = new JButton("Done");
        jb_lend_back = new JButton("Back");
        jb_lend_done.setBounds(550, 300, 100, 30);
        jb_lend_back.setBounds(400, 300, 100, 30);
        
        l_lendBook.add(jb_lend_back);        
        l_lendBook.add(jb_lend_done);
        
        l_lendBook.add(jt_AssignBook_memberId);        
        l_lendBook.add(jt_AssignBook_BookId);        
        l_lendBook.add(jt_AssignBook_Date);        
        l_lendBook.add(jt_AssignBook_exDate);
        
        l_lendBook.add(l_AssignBook_memberId);        
        l_lendBook.add(l_AssignBook_BookId);                
        l_lendBook.add(l_AssignBook_Date);        
        l_lendBook.add(l_AssignBook_exDate);        
        l_lendBook.add(l_assignresult);

        /*................end land book....................*/
        
        
        /*............................
         * .............................
         * ..............................start return book...........*/
        
        l_AssignBook_memberId2 = new JLabel("Enter Member ID :");
        l_AssignBook_BookId2 = new JLabel("Enter Book ID   :");        
        l_assigndeleteresult=new JLabel();
        
        l_AssignBook_memberId2.setBounds(300, 100, 200, 30);
        l_AssignBook_memberId2.setFont(new Font("Courier New", 1, 17));
        l_AssignBook_memberId2.setForeground(Color.YELLOW);
        
        l_AssignBook_BookId2.setBounds(300, 150, 200, 30);
        l_AssignBook_BookId2.setFont(new Font("Courier New", 1, 17));
        l_AssignBook_BookId2.setForeground(Color.YELLOW);
        
        l_assigndeleteresult.setBounds(300, 250, 400, 30);
        l_assigndeleteresult.setFont(new Font("Courier New", 1, 17));
        l_assigndeleteresult.setForeground(Color.YELLOW);
        
        
        jt_AssignBook_memberId2=new JTextField(8);
        jt_AssignBook_BookId2=new JTextField(8);
        
        jt_AssignBook_memberId2.setBounds(550, 100, 100, 30);
        jt_AssignBook_BookId2.setBounds(550, 150, 100, 30);                
        
        jb_return_done = new JButton("Done");
        jb_return_back = new JButton("Back");
        jb_return_done.setBounds(550, 200, 100, 30);
        jb_return_back.setBounds(400, 200, 100, 30);                        
                                                         
        l_returnBook.add(l_AssignBook_memberId2);                                            
        l_returnBook.add(l_AssignBook_BookId2);                                            
        l_returnBook.add(l_assigndeleteresult);                                            
        l_returnBook.add(jt_AssignBook_memberId2);                                           
        l_returnBook.add(jt_AssignBook_BookId2);                                                    
        l_returnBook.add(jb_return_back);                                            
        l_returnBook.add(jb_return_done);
     
                                            
        
       /*..............................
        * .................................end return book.........*/
        
        /*............ ............end assignBook.............*/
        
        
        /*......................start ststus.........................*/
        jpn_ststus_show=new JPanel();        
        jpn_ststus_show.setBounds(300, 100, 650, 445);
        
        jta_status_show=new JTextArea(27, 57 );
        jta_status_show.setEditable ( false );
       // jta_memberPage.setBounds(300, 100, 650, 350);
                
        jscrolbar_ststus=new JScrollPane(jta_status_show);        
        jscrolbar_ststus.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );        
        
        //jpn_memberEnty.add(jta_memberPage);
         jpn_ststus_show.add(jscrolbar_ststus);
         l_Status.add(jpn_ststus_show);        
        
        
        /*.................end ststus........................*/
         
         /*....................start account..........*/
        
         l_oldUserName = new JLabel("Enter Old User Name :");
        l_oldUserPassword = new JLabel("Enter Old Password :");
        l_newUserName = new JLabel("Enter New User Name :");
        l_newUserPassword = new JLabel("Enter New Password :");
        
        
        l_oldUserName.setBounds(300, 100, 230, 30);
        l_oldUserName.setFont(new Font("Courier New", 1, 17));
        l_oldUserName.setForeground(Color.YELLOW);
        
        l_oldUserPassword.setBounds(300, 150, 200, 30);
        l_oldUserPassword.setFont(new Font("Courier New", 1, 17));
        l_oldUserPassword.setForeground(Color.YELLOW);
        
        l_newUserName.setBounds(300, 200, 230, 30);
        l_newUserName.setFont(new Font("Courier New", 1, 17));
        l_newUserName.setForeground(Color.YELLOW);
        
        l_newUserPassword.setBounds(300, 250, 200, 30);
        l_newUserPassword.setFont(new Font("Courier New", 1, 17));
        l_newUserPassword.setForeground(Color.YELLOW);
        
        jt_oldUserName=new JTextField(8);
        jt_oldUserPassword=new JTextField(8);
        jt_newUserName=new JTextField(8);
        jt_newUserPassword=new JTextField(8);
        
        jt_oldUserName.setBounds(550, 100, 100, 30);
        jt_oldUserPassword.setBounds(550, 150, 100, 30);
        jt_newUserName.setBounds(550, 200, 100, 30);
        jt_newUserPassword.setBounds(550, 250, 100, 30);
        
        myaccount_done = new JButton("Done");        
        myaccount_done.setBounds(550, 300, 100, 30);
        
        l_MyAccount.add(l_oldUserName);
        l_MyAccount.add(l_oldUserPassword);
        l_MyAccount.add(l_newUserName);
        l_MyAccount.add(l_newUserPassword);
        
        l_MyAccount.add(jt_oldUserName);
        l_MyAccount.add(jt_oldUserPassword);
        l_MyAccount.add(jt_newUserName);
        l_MyAccount.add(jt_newUserPassword);
        
        l_MyAccount.add(myaccount_done);
         /*.....................end account...................*/
       jbn1=new JButton("log in");              
       jbn1.setBounds(470, 440, 150, 30);
       l_login.add(jbn1);
       
       jta1=new JTextField();
       jta1.setFont(new Font("Arial", Font.BOLD, 30));
       jta2=new JPasswordField();
      
       jta2.setFont(new Font("Arial", Font.BOLD, 30));
       jta1.setBounds(450, 240, 200, 30);
       l_login.add(jta1);
       
       jta2.setBounds(450, 340, 200, 30);
       l_login.add(jta2);
       
       
            l1 = new JLabel("User Id:");

        l1.setFont(new Font("Arial", Font.BOLD, 30));
        l1.setForeground(Color.DARK_GRAY);
        l1.setBounds(200, 200, 300, 100);
        add(l1);

        l2=new JLabel("Password:");
        l2.setFont(new Font("Arial", Font.BOLD, 30));
        l2.setForeground(Color.DARK_GRAY);
        l2.setBounds(200, 300, 300, 100);
        add(l2);

   
      // final dbcon d=new dbcon();
       jbn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                  Connection conn = null;
                    try 
                    {
                        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank1", "root","idea");
                        System.out.println(" successfull connect");
                        final Statement st = conn.createStatement();
                        try
                        {                    
                            
                           // st.executeUpdate("create table b_status_table(memberID char (10),bookID char(15),date DATE,exdate char (20))");                           
                           // st.executeUpdate("drop table b_status_table1");
                           // st.executeUpdate("drop table b_log_table");
                            //st.executeUpdate("drop table b_reg_table1");
                            //st.executeUpdate("drop table b_book_table1");
                           
                            String table = "CREATE TABLE b_log_table(username varchar(20), password varchar(20))";
                            st.executeUpdate(table);
                            String insert_value_b_log_table="insert into b_log_table(username,password)" + "values('mbstu','cse');";                          
                            st.executeUpdate(insert_value_b_log_table);
                            st.executeUpdate("create table b_reg_table1(memberID char (10),studentID char(15),StudentName char(50),department char(30),stu_session char(10),sex char(10),currentAddr char(100),parmanentAddr char(100),contract char(20),constraint pk_reg_table primary key(memberID))");                                                       
                           st.executeUpdate("create table b_book_table1(book_number char (10),book_name char(40),categary char(30),deparment char(10),author char(40),edition char(30),release_year char(10),price char(10),constraint pk_b_book_table primary key(book_number))");
                            
                           
                            st.executeUpdate("create table b_status_table1(memberID char (10),book_number char(15),cudate char(20),exdate char(20),constraint pk_4 primary key(memberID),constraint fk_4 foreign key(memberID)references b_reg_table1(memberID),constraint fk_5 foreign key(book_number)references b_book_table1(book_number))");                           
                            System.out.println("one");
                            
                            System.out.println("two");
                             System.out.println("three");
                            
                            
                            System.out.println("success...........1234567890");
                            
                        }
                        catch(Exception ex)
                        {
                            System.out.println("already table create..........");
                        }
                        
                        ResultSet res = st.executeQuery("select * from b_log_table");
                        
                        String username = null,password = null;
                        while(res.next()==true)                                 
                        { // process results one row at a time                                     
                            username = res.getString("username");                                   
                            password = res.getString("password");                                                            
                        }
                        if(username.equals(jta1.getText())&&password.equals(jta2.getText()))
                        {
                            /*......................Home page...................*/
                            
                            setContentPane(l_home);
                            //jpn_registration.add(l_home);
                            
                            jb_home.addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent e) 
                                {
                                   
                                    l_home.add(jb_home);
                                    l_home.add(jb_registration);
                                    l_home.add(jb_book);
                                    l_home.add(jb_member);
                                    l_home.add(jb_AssingBook);
                                    l_home.add(jb_Status);
                                    l_home.add(jb_MyAccount); 
                                   
                                    setContentPane(l_home);
                                  //  jpn_registration.add(l_home);
                            
                                }
                            });
                            /*....................end Home page..................*/
                            
                            /*...........registration................*/
                               jb_registration.addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent e) 
                                {
                                            
                                    l_registration.add(jb_home);
                                    l_registration.add(jb_registration);
                                    l_registration.add(jb_book);
                                    l_registration.add(jb_member); 
                                    l_registration.add(jb_AssingBook);
                                    l_registration.add(jb_Status);
                                    l_registration.add(jb_MyAccount); 
                                    
                                    setContentPane(l_registration);                                                           

                                  // jta_memberPage.setText(s);
                                   jb_reg_save.addActionListener(new ActionListener() {

                                        @Override
                                        public void actionPerformed(ActionEvent e) 
                                        {
                                            int count=0;
                                            String s_memberID,s_studentID,s_studentName,s_department,s_session,s_sex,s_parmanentAddr,s_currentAddr,s_contract;
                                            s_memberID=jt_MemberID.getText();
                                            s_studentID=jt_StudentID.getText();
                                            s_studentName=jt_StudentName.getText();
                                            s_department=jt_Department.getText();
                                            s_session=jt_Session.getText();
                                            if(M.isSelected()==true)
                                                s_sex="Male";
                                            else
                                                s_sex="Female";
                                            s_currentAddr=jt_CurrentAddr.getText();
                                            s_parmanentAddr=jt_parmamentAddr.getText();
                                            s_contract=jt_ContractNo.getText();
                                            System.out.println(s_memberID+"  "+s_studentID+"  "+s_studentName+" "+s_department+" "+s_session+" "+s_currentAddr+" "+s_parmanentAddr+" "+s_contract);
                                            try
                                            {                                      
                                                if(s_memberID.compareTo("")==0||s_studentID.compareTo("")==0||s_studentName.compareTo("")==0||s_department.compareTo("")==0||s_session.compareTo("")==0||s_currentAddr.compareTo("")==0||s_parmanentAddr.compareTo("")==0||s_contract.compareTo("")==0)                                                    
                                                {
                                                    
                                                }
                                                else
                                                {
                                                    
                                                    String insert_value_b_reg_table="insert into b_reg_table1(memberID,studentID,StudentName,department,stu_session,sex,parmanentAddr,currentAddr,contract)" + "values('"+s_memberID+"','"+s_studentID+"','"+s_studentName+"','"+s_department+"','"+s_session+"','"+s_sex+"','"+s_currentAddr+"','"+s_parmanentAddr+"','"+s_contract+"');";                                                
                                                    st.executeUpdate(insert_value_b_reg_table);  
                                                    ++count;
                                                    jt_MemberID.setText(s1);
                                                    jt_StudentID.setText(s1);
                                                    jt_StudentName.setText(s1);
                                                    jt_Department.setText(s1);
                                                    jt_Session.setText(s1);
                                                    jt_CurrentAddr.setText(s1);
                                                    jt_parmamentAddr.setText(s1);
                                                    jt_ContractNo.setText(s1);
                                                   
                                                    
                                                }
                                                if(count!=0)
                                                     JOptionPane.showMessageDialog(null, "!!!Success fully add!!!");
                                                
                                            }
                                            catch(Exception ex)
                                            {
                                                jt_MemberID.setText(s1);
                                                    jt_StudentID.setText(s1);
                                                    jt_StudentName.setText(s1);
                                                    jt_Department.setText(s1);
                                                    jt_Session.setText(s1);
                                                    jt_CurrentAddr.setText(s1);
                                                    jt_parmamentAddr.setText(s1);
                                                    jt_ContractNo.setText(s1);
                                               //  jta_memberPage.setText(s);
                                                 JOptionPane.showMessageDialog(null, "!!!Some error occur!!!");
                                            }
                                            
                                            
                                        }
                                    });
                                   // jpn.add(l_home);
                            
                                }
                            });
                            /*..............end registration...........*/
                               
                               
                               /*.............start member page......................*/
                               jb_member.addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent e) 
                                {                                                                        
                                    l_member.add(jb_home);
                                    l_member.add(jb_registration);
                                    l_member.add(jb_book);
                                    l_member.add(jb_member);
                                    l_member.add(jb_AssingBook);
                                    l_member.add(jb_Status);
                                    l_member.add(jb_MyAccount); 
                                          
                                    setContentPane(l_member);
                                   //  jta_memberPage.setText(s);
                                    try
                                    {
                                        ResultSet res = st.executeQuery("select * from b_reg_table1");
                                        String s_memberID,s_studentID,s_studentName,s_department,s_session,s_sex,s_parmanentAddr,s_currentAddr,s_contract;
                                       s="";
                                        while(res.next()==true)                                 
                                        { // process results one row at a time   
                                            s_memberID = res.getString("memberID");                                   
                                            s_studentID = res.getString("studentID");
                                            s_studentName=res.getString("StudentName");
                                           s_department=res.getString("department");
                                           s_session=res.getString("stu_session");
                                           s_sex=res.getString("sex");
                                           s_currentAddr=res.getString("currentAddr");
                                           s_parmanentAddr=res.getString("parmanentAddr");
                                           s_contract=res.getString("contract");
                                           //System.out.println("yes");
                                           s=s+("\nMember ID : "+s_memberID+"\nStudent ID : "+s_studentID+"\nStudent Name : "+s_studentName+"\nDepartment : "+s_department+"\nSession : "+s_session+"\nCurrent Address : "+s_currentAddr+"\nParmanent Address : "+s_parmanentAddr+"\nContract no : "+s_contract+"\n________________________________________________");                                     
                                        }
                                         
                                        jta_memberPage.setText(s);
                                        
                                        
                                        
                                        
                                    }
                                    catch(Exception ex)
                                    {
                                                JOptionPane.showMessageDialog(null, "!!!Some error occur!!!");
                                    }
                                    jb_delete_member.addActionListener(new ActionListener() {

                                        @Override
                                        public void actionPerformed(ActionEvent e) 
                                        {
                                            try
                                            {
                                                int count=0;
                                                st.executeUpdate("delete from b_reg_table1 where memberID='"+jt_delete_member.getText()+"'");
                                                ResultSet res = st.executeQuery("select * from b_reg_table1");
                                                    String s_memberID,s_studentID,s_studentName,s_department,s_session,s_sex,s_parmanentAddr,s_currentAddr,s_contract;
                                                        s="";
                                                    while(res.next()==true)                                 
                                                    { // process results one row at a time   
                                                        s_memberID = res.getString("memberID");                                   
                                                        s_studentID = res.getString("studentID");
                                                        s_studentName=res.getString("StudentName");
                                                       s_department=res.getString("department");
                                                       s_session=res.getString("stu_session");
                                                       s_sex=res.getString("sex");
                                                       s_currentAddr=res.getString("currentAddr");
                                                       s_parmanentAddr=res.getString("parmanentAddr");
                                                       s_contract=res.getString("contract");
                                                      // System.out.println("yes");
                                                       s=s+("\nMember ID : "+s_memberID+"\nStudent ID : "+s_studentID+"\nStudent Name : "+s_studentName+"\nDepartment : "+s_department+"\nSession : "+s_session+"\nCurrent Address : "+s_currentAddr+"\nParmanent Address : "+s_parmanentAddr+"\nContract no : "+s_contract+"\n________________________________________________");                                     
                                                       
                                                    }
                                                            JOptionPane.showMessageDialog(null, "!!!Successfully delete!!!");
                                                    jta_memberPage.setText(s);
                                                    //jta_memberPage.setFont(new Font("Segoe Script", Font.BOLD, 20));

                                            }
                                            catch(Exception ex)
                                            {
                                                        JOptionPane.showMessageDialog(null, "!!!Some error occur!!!");
                                            }
                                            
                                        }
                                    });
                                  //  jta_memberPage.setFont(new Font(s1, WIDTH, i));
                                    //jta_memberPage.setFont(new Font("Arial", Font.BOLD, 20));
                                }
                                
                            });
                               /*.................end member page..........................*/
                               
                               /*...................book................*/
                               
                               jb_book.addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent e) 
                                {
                                    l_book.add(jb_home);
                                    l_book.add(jb_registration);
                                    l_book.add(jb_book);
                                    l_book.add(jb_member);
                                    l_book.add(jb_bookSearch);
                                    l_book.add(jb_bookInsert);
                                    l_book.add(jb_bookDelete);
                                    l_book.add(jb_AssingBook);
                                    l_book.add(jb_Status);
                                    l_book.add(jb_MyAccount); 
                                          
                                    setContentPane(l_book);
                                    try
                                    {
                                        String p,s_book_number,s_book_name,s_categary,s_department,s_author,s_edition,s_release_year,s_price;
                                        ResultSet res = st.executeQuery("select * from b_book_table1");
                                          //  String s_memberID,s_studentID,s_studentName,s_department,s_session,s_sex,s_parmanentAddr,s_currentAddr,s_contract;
                                           s="";
                                           String t1,t2,t3,t4;
                                            while(res.next()==true)                                 
                                            { // process results one row at a time   
                                                s_book_number = res.getString("book_number");                                   
                                                s_book_name = res.getString("book_name");                                                
                                               s_department=res.getString("deparment");                                                                                              
                                               s_release_year=res.getString("release_year");                                               
                                               
                                               //System.out.println("yes");
                                               s=s+("Book ID   : "+s_book_number+"            Book Name   : "+s_book_name+"            Department   :   "+s_department+"            Release Year   : "+s_release_year+"\n"+"___________________________________________________________________________________________\n");
                                            }
                                            
                                            jta_bookenty.setText(s);

                                    }
                                    catch(Exception ex)
                                    {
                                                
                                        JOptionPane.showMessageDialog(null, "!!!Some error occur!!!");
                                    }                                    
                                    
                                    jb_bookSearch.addActionListener(new ActionListener() {

                                       @Override
                                       public void actionPerformed(ActionEvent e) 
                                       {
                                          l_book_search.add(jb_home);
                                          l_book_search.add(jb_registration);
                                          l_book_search.add(jb_book);
                                          l_book_search.add(jb_member);
                                          l_book_search.add(jb_bookSearch);
                                          l_book_search.add(jb_bookInsert);
                                          l_book_search.add(jb_bookDelete);
                                          l_book_search.add(jb_AssingBook);
                                          l_book_search.add(jb_Status);
                                          l_book_search.add(jb_MyAccount); 
                                          
                                          // l_book_search.add(jb_book_search);

                                          setContentPane(l_book_search);
                                          jb_book_search.addActionListener(new ActionListener() {

                                              @Override
                                              public void actionPerformed(ActionEvent e) 
                                              {
                                                try
                                                  {
                                                      String p,s_book_number,s_book_name,s_categary,s_department,s_author,s_edition,s_release_year,s_price;
                                                      ResultSet res = st.executeQuery("select * from b_book_table1 where book_name LIKE '%"+jt_book_search.getText()+"%'");
                                                      //    String s_memberID,s_studentID,s_studentName,s_department,s_session,s_sex,s_parmanentAddr,s_currentAddr,s_contract;
                                                         p="    Book List";s="";
                                                          while(res.next()==true)                                 
                                                          { // process results one row at a time   
                                                              s_book_number = res.getString("book_number");                                   
                                                              s_book_name = res.getString("book_name");     
                                                              s_categary=res.getString("categary");                                                        
                                                             s_department=res.getString("deparment");
                                                             s_author=res.getString("author");
                                                             s_edition=res.getString("edition");
                                                             s_release_year=res.getString("release_year");                                                       
                                                             s_price=res.getString("price");                                               

                                                             //System.out.println("yes");
                                                             s=s+("\nBook ID   : "+s_book_number+"\nBook Name   : "+s_book_name+"\nCategory   : "+s_categary+"\nDepartment   : "+s_department+"\nAuthor  : "+s_author+"\n Edition  : "+s_edition+"\nRelease Year  : "+s_release_year+"\nPrice  : "+s_price);
                                                          }                                                          
                                                          
                                                         
                                                          jta_book_show.setText(p+s);                                                     

                                                  }
                                                  catch(Exception ex)
                                                  {
                                                   
                                                      JOptionPane.showMessageDialog(null, "!!!Some error occur!!!");
                                                  }                                    
   
                                              }
                                          });
                                          
                                       }
                                   });
                                    jb_bookInsert.addActionListener(new ActionListener() {

                                       @Override
                                       public void actionPerformed(ActionEvent e) 
                                       {
                                          l_book_insert.add(jb_home);
                                          l_book_insert.add(jb_registration);
                                          l_book_insert.add(jb_book);
                                          l_book_insert.add(jb_member);
                                          l_book_insert.add(jb_bookSearch);
                                          l_book_insert.add(jb_bookInsert);
                                          l_book_insert.add(jb_bookDelete);
                                          l_book_insert.add(jb_AssingBook);
                                          l_book_insert.add(jb_Status);
                                          l_book_insert.add(jb_MyAccount); 
                                          
                                          
                                          setContentPane(l_book_insert);   
                                          jb_book_save.addActionListener(new ActionListener() {

                                          
                                              @Override
                                              public void actionPerformed(ActionEvent e) 
                                              {
                                                    try
                                                    {
                                                        int count=0;
                                                          String s_book_number,s_book_name,s_categary,s_department,s_author,s_edition,s_release_year,s_price;

                                                          s_book_number=jt_book_number.getText();
                                                          s_book_name=jt_book_name.getText();
                                                          s_categary=ct.getSelectedItem().toString();
                                                          //s_categary=ct.getName();
                                                          //s_department=dpt.getName();
                                                          s_department=dpt.getSelectedItem().toString();
                                                          s_author=jt_book_Author.getText();
                                                          //s_edition=edt.getName();
                                                          s_edition=edt.getSelectedItem().toString();
                                                          s_release_year=jt_book_Release_Year.getText();                                            
                                                          s_price=jt_book_Price.getText();
                                                          
                                                          if(s_categary.compareTo("Select Category")==0)
                                                          {
                                                              s_categary="";
                                                          }                                                          
                                                          if(s_department.compareTo("Select Department")==0)
                                                          {
                                                              s_department="";
                                                          }
                                                          if(s_edition.compareTo("Select Edition")==0)
                                                          {
                                                              s_edition="";
                                                          }
                                                          System.out.println(s_department);
                                                          String insert_value_b_book_table="insert into b_book_table1(book_number,book_name,categary,deparment,author,edition,release_year,price)" + "values('"+s_book_number+"','"+s_book_name+"','"+s_categary+"','"+s_department+"','"+s_author+"','"+s_edition+"','"+s_release_year+"','"+s_price+"');";                                                
                                                          if(s_book_number.compareTo("")==0||s_book_name.compareTo("")==0||s_categary.compareTo("")==0||s_department.compareTo("")==0||s_author.compareTo("")==0||s_edition.compareTo("")==0||s_release_year.compareTo("")==0||s_price.compareTo("")==0)
                                                          {
                                                              System.out.println("h=="+s_book_number);
                                                              
                                                          }
                                                          else
                                                          {
                                                           //   System.out.println(s_author+s_book_name+s_book_number+s_categary+s_department+s_edition+s_price+s_release_year);
                                                              st.executeUpdate(insert_value_b_book_table);
                                                              ++count;
                                                              jt_book_number.setText("");
                                                              jt_book_name.setText("");
                                                              jt_book_Author.setText("");
                                                              jt_book_Release_Year.setText("");
                                                              jt_book_Price.setText("");
                                                          }
                                                          if(count!=0)
                                                                      JOptionPane.showMessageDialog(null, "!!!Successfully insert!!!");
                                                    }
                                                      catch(Exception ex)
                                                      {
                                                              jt_book_number.setText("");
                                                              jt_book_name.setText("");
                                                              jt_book_Author.setText("");
                                                              jt_book_Release_Year.setText("");
                                                              jt_book_Price.setText("");
                                                                  JOptionPane.showMessageDialog(null, "!!!Some error occur!!!");
                                                      }

                                              }
                                          });
                                          
                                          
                                          
                                          
                                       }
                                   });
                                    jb_bookDelete.addActionListener(new ActionListener() {

                                       @Override
                                       public void actionPerformed(ActionEvent e) 
                                       {
                                           jt_book_delete.setText("");
                                           jt_book_delete2.setText("");
                                          l_book_delete.add(jb_home);
                                          l_book_delete.add(jb_registration);
                                          l_book_delete.add(jb_book);
                                          l_book_delete.add(jb_member);
                                          l_book_delete.add(jb_bookSearch);
                                          l_book_delete.add(jb_bookInsert);
                                          l_book_delete.add(jb_bookDelete);
                                          l_book_delete.add(jb_AssingBook);
                                          l_book_delete.add(jb_Status);
                                          l_book_delete.add(jb_MyAccount); 
                                          setContentPane(l_book_delete);  
                                          jb_book_delete.addActionListener(new ActionListener() {

                                              @Override
                                              public void actionPerformed(ActionEvent e) 
                                              {
                                                  try
                                                {                                                   
                                                   
                                                    int j=0,count=0;
                                                    ResultSet res = st.executeQuery("select count(book_number) from b_book_table1 group by book_number having book_number='"+jt_book_delete.getText()+"'");
                                                    while(res.next()==true)
                                                    {
                                                        ++j;
                                                      //  p=res1.getString("count(book_name)");
                                                    }
                                                    System.out.println("value of j"+j);
                                                    if(j>0)
                                                    {
                                                        System.out.println("value of j   ==="+j);
                                                        st.executeUpdate("delete from b_book_table1 where book_number='"+jt_book_delete.getText()+"'");
                                                        ++count;
                                                        
                                                    }
                                                    else 
                                                    {
                                                    }
                                                    if(count!=0)
                                                                JOptionPane.showMessageDialog(null, "!!!Successfully delete!!!");
                                                }
                                                catch(Exception ex)
                                                {
                                                            JOptionPane.showMessageDialog(null, "!!!Some error occur!!!");
                                                }
                                              
                                              }
                                          });
                                       }
                                   });
                                }
                            });
                               /*.....................end book.................*/
                               
                               jb_AssingBook.addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent e) 
                                {
                                 
                                    l_AssingBook.add(jb_home);
                                    l_AssingBook.add(jb_registration);
                                    l_AssingBook.add(jb_book);
                                    l_AssingBook.add(jb_member);                                            
                                    l_AssingBook.add(jb_AssingBook);
                                    l_AssingBook.add(jb_Status);
                                    l_AssingBook.add(jb_MyAccount);                                          
                                    setContentPane(l_AssingBook);
                                    
                                    jb_lendBook.addActionListener(new ActionListener() {

                                        @Override
                                        public void actionPerformed(ActionEvent e) 
                                        {                                                   
       
                                            l_lendBook.add(jb_home);
                                            l_lendBook.add(jb_registration);
                                            l_lendBook.add(jb_book);
                                            l_lendBook.add(jb_member);                                            
                                            l_lendBook.add(jb_AssingBook);
                                            l_lendBook.add(jb_Status);
                                            l_lendBook.add(jb_MyAccount);                                          
                                    
                                            setContentPane(l_lendBook);
                                            /*jb_lend_back.addActionListener(new ActionListener() {

                                                @Override
                                                public void actionPerformed(ActionEvent e) 
                                                {
                                                    l_AssingBook.add(jb_home);
                                                    l_AssingBook.add(jb_registration);
                                                    l_AssingBook.add(jb_book);
                                                    l_AssingBook.add(jb_member);                                            
                                                    l_AssingBook.add(jb_AssingBook);
                                                    l_AssingBook.add(jb_Status);
                                                    l_AssingBook.add(jb_MyAccount);                                     
                                                    setContentPane(l_AssingBook);
                                                }
                                            });*/
                                            
                                            jb_lend_done.addActionListener(new ActionListener() {

                                                @Override
                                                public void actionPerformed(ActionEvent e) 
                                                {
                                                    
                                                    try
                                                    {
                                                       l_assignresult.setText("");
                                                      int j1=0,i1=0,count=0;
                                                      
                                                        ResultSet res = st.executeQuery("select count(book_number) from b_status_table1 group by book_number having book_number='"+jt_AssignBook_BookId.getText()+"'");                                                                                                            
                                                        while(res.next()==true)
                                                        {                                                                                                                                 
                                                             ++j1;
                                                        }
                                                       if(j1>0)
                                                        {
                                                        }
                                                        else 
                                                        {
                                                            String insert_value_b_status_table="insert into b_status_table1(memberID,book_number,cudate,exdate)" + "values('"+jt_AssignBook_memberId.getText()+"','"+jt_AssignBook_BookId.getText()+"','"+jt_AssignBook_Date.getText()+"','"+jt_AssignBook_exDate.getText()+"');";                                                        
                                                            st.executeUpdate(insert_value_b_status_table);
                                                            ++count;
                                                            //System.out.println("there's successfully to add");
                                                            
                                                        } 
                                                       if(count!=0) 
                                                         JOptionPane.showMessageDialog(null, "!!!Successfully lend Book!!!");
                                                      // l_assignresult.setText("there's successfully to add");   
                                                        
                                                    }
                                                    catch(Exception ex)
                                                    {
                                                                
                                                        JOptionPane.showMessageDialog(null, "!!!Some error occur!!!");
                                                    }   
                                                }
                                            });
                                        }
                                        
                                    });
                                    jb_returnBook.addActionListener(new ActionListener() {

                                        @Override
                                        public void actionPerformed(ActionEvent e) 
                                        {
                                            l_returnBook.add(jb_home);
                                            l_returnBook.add(jb_registration);
                                            l_returnBook.add(jb_book);
                                            l_returnBook.add(jb_member);                                            
                                            l_returnBook.add(jb_AssingBook);
                                            l_returnBook.add(jb_Status);
                                            l_returnBook.add(jb_MyAccount);                                          
                                                                               
                                            
                                            setContentPane(l_returnBook);
                                            
                                           /* jb_return_back.addActionListener(new ActionListener() {

                                                @Override
                                                public void actionPerformed(ActionEvent e) 
                                                {
                                                    l_AssingBook.add(jb_home);
                                                    l_AssingBook.add(jb_registration);
                                                    l_AssingBook.add(jb_book);
                                                    l_AssingBook.add(jb_member);                                            
                                                    l_AssingBook.add(jb_AssingBook);
                                                    l_AssingBook.add(jb_Status);
                                                    l_AssingBook.add(jb_MyAccount);                                                     
                                                    setContentPane(l_AssingBook);
                                                }
                                            });*/
                                            jb_return_done.addActionListener(new ActionListener() {

                                                @Override
                                                public void actionPerformed(ActionEvent e) 
                                                {
                                                    try                                                         
                                                    {       
                                                        l_assigndeleteresult.setText("");
                                                        int j=0,count=0;
                                                        ResultSet res = st.executeQuery("select count(book_number) from b_status_table1 group by book_number having book_number='"+jt_AssignBook_BookId2.getText()+"'");
                                                        while(res.next()==true)
                                                        {
                                                            ++j;
                                                          //  p=res1.getString("count(book_name)");
                                                        }
                                                        System.out.println("value of j"+j);
                                                        if(j>0)
                                                        {
                                                            st.executeUpdate("delete from b_status_table1 where book_number='"+jt_AssignBook_BookId2.getText()+"' and memberID='"+jt_AssignBook_memberId2.getText()+"' ");
                                                            ++count;
                                                        }
                                                        else 
                                                        {
                                                        }
                                                        if(count!=0)
                                                                    JOptionPane.showMessageDialog(null, "!!!Successfully return Book!!!");
                                                    }                                    
                                                    catch(Exception ex)                                    
                                                    {                                                                                                    
                                                        JOptionPane.showMessageDialog(null, "!!!Some error occur!!!");                                                                
                                                    }                                   

                                                }
                                            });
                                 
                                        }
                                    });
                                          
                                }
                            });
                               jb_Status.addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent e) 
                                {
                                       
                                    l_Status.add(jb_home);                                       
                                    l_Status.add(jb_registration);
                                    l_Status.add(jb_book);
                                    l_Status.add(jb_member);                                            
                                    l_Status.add(jb_AssingBook);
                                    l_Status.add(jb_Status);
                                    l_Status.add(jb_MyAccount);                                                                                                                          
                                    l_Status.add(jb_home);
                                    setContentPane(l_Status);
                                    try                                                         
                                    {       
                                        String p1,p2,p3,p4,s="";
                                        ResultSet res = st.executeQuery("select * from b_status_table1");                                                                                                                                                                                                           
                                        while(res.next()==true)                                        
                                        {                                                                                                                                                               
                                            p1=res.getString("memberID");
                                            p2=res.getString("book_number");
                                            p3=res.getString("cudate");
                                            p4=res.getString("exdate");
                                            s+="Member ID : "+p1+"                 Book ID: "+p2+"              Issue Date: "+p3+"                       Exdate: "+p4+"\n____________________________________________________________________________________________\n";
                                        }                                                                                 
                                        jta_status_show.setText(s);
                                    }                                    
                                    catch(Exception ex)                                    
                                    {                                    
                                        System.out.println("there's problem to add");                                        
                                    }                                   
                                }
                            });

                                   
                               jb_MyAccount.addActionListener(new ActionListener() 
                               {

                                @Override
                                public void actionPerformed(ActionEvent e) 
                                {
                                    l_MyAccount.add(jb_home);                                       
                                    l_MyAccount.add(jb_registration);
                                    l_MyAccount.add(jb_book);
                                    l_MyAccount.add(jb_member);                                            
                                    l_MyAccount.add(jb_AssingBook);
                                    l_MyAccount.add(jb_Status);
                                    l_MyAccount.add(jb_MyAccount);                                                                                                                          
                                    l_MyAccount.add(jb_home);
                                    setContentPane(l_MyAccount);
                               
                                    myaccount_done.addActionListener(new ActionListener() {

                                        @Override
                                        public void actionPerformed(ActionEvent e) 
                                        {
                                       try
                                            {
                                                ResultSet res = st.executeQuery("select * from b_log_table");

                                                int count=0;
                                               String username ="",password ="",s1="",s2="",s3="",s4="";
                                               while(res.next()==true)                                 
                                               { // process results one row at a time                                     
                                                   username = res.getString("username");                                   
                                                   password = res.getString("password");                                                            
                                               }
                                               s1=jt_oldUserName.getText();
                                               s2=jt_oldUserPassword.getText();
                                               s3=jt_newUserName.getText();
                                               s4=jt_newUserPassword.getText();
                                               System.out.println(s1+" "+s2+" "+s3+" "+s4+" "+password);
                                               if(s1.compareTo("")==0||s2.compareTo("")==0||s3.compareTo("")==0||s4.compareTo("")==0)
                                               {
                                                   
                                               }
                                               else
                                               {
                                                   if(username.compareTo(s1)==0&&password.compareTo(s2)==0)
                                                   {
                                                        String insert_value_b_log_table="insert into b_log_table(username,password)" + "values('"+jt_newUserName.getText()+"','"+jt_newUserPassword.getText()+"');";                          
                                                        st.executeUpdate(insert_value_b_log_table);
                                                        ++count;
                                                   }
                                                   else
                                                   {
                                                       
                                                   }
                                               }
                                               if(count!=0)
                                                  JOptionPane.showMessageDialog(null, "!!!Successfully change account info!!!");

                                            }
                                            catch (Exception ex) 
                                            {
                                                         JOptionPane.showMessageDialog(null, "!!!Some error occur!!!");
                                            }
                                        }
                                    });
                                    
                                 }
                            });
                            System.out.println(" successfull connect book management");
                        }
                        else
                        {
                              System.out.println(" unsuccessfull connect");
                        }
                        
                    
                    } 
                    catch (Exception ex) 
                    {
                         ex.printStackTrace();
                    }

            }
        });
       
    }
    
}
/*.......................end LogIn page.........................*/