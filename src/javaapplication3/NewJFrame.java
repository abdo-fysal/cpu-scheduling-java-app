/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author aboda
 */
public class NewJFrame extends javax.swing.JFrame {
    public class process
    {
        public int data;
        public int arrived_time;
        public int burst_time;
        public int priority;
        public int Quantum;
        public int done;
          public int remain;
           public int co;
           public int counter;
           
           public int done1;
        public process(int A,int B,int P,int Q,int d,int o,int x,int y,int z,int u)
        {
            data = d;
            arrived_time = A;
            burst_time = B;
            priority = P;
            Quantum = Q;
            done=o;
            remain=x;
            co=y;
            done1=z;
            counter=u;
         
           
        }
    }

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
    }
    
    List<process> L = new ArrayList<process>();   
        List<JButton> E = new ArrayList<JButton>();   

int k=0;
JFrame s=new JFrame();
int min=0;
int m=1;
JPanel panel = new JPanel();


        int index = 0;
        int avg_waiting = 0;
        int in=0;
        int waiting = 0;
        int start = 0;
        int uu=0;
        int counter=0;
        void take_process( int A, int B,int P, int Q,int D,int O,int x,int y)
        {
            process input=new process(A,B,P,Q,D,0,0,0,0,0);
            
            input.arrived_time = A;
            input.burst_time = B;
            input.Quantum = Q;
            input.priority=P;
            input.data=D;
            input.done=O;
            input.co=uu;
            input.done1=0;
            input.counter=0;
            uu++;
            

            L.add(k,input);
             JButton button = new JButton();
            E.add(k,button);
            k=k+1;
           


        }
         int c=0;
         
        void FCFS()
        {
            s.setSize(400,400);
            s.setLocationRelativeTo(null);
            BorderLayout b=new BorderLayout();
               FlowLayout f=new FlowLayout();
               GridLayout g=new GridLayout();
               s.setLayout(f);
           
           
            for (int j = 0;j < L.size(); j++){
                if(L.get(j).done==0){
                 min = L.get(j).arrived_time;
                 index=j;

            for (int i = 0; i < L.size(); i++)
            {                if(L.get(i).done==0){
                if (L.get(i).arrived_time != min){
                

                if (L.get(i).arrived_time < min)
                {
                    min = L.get(i).arrived_time;
                    index = i;
                }
                }
            }

            }
            if (index == 0)
            {
                start = L.get(index).arrived_time + L.get(index).burst_time;
                counter++;
                 
                E.get(index).setText("P"+Integer.toString(c));
               E.get(index).setBounds(m, 0 ,1, 1);
               
               E.get(index).setPreferredSize(new Dimension(L.get(index).burst_time*20, 40));
               
               if(j==0){
                JTextField in1=new JTextField(Integer.toString(L.get(index).arrived_time));
                JTextField in2=new JTextField(Integer.toString(L.get(index).arrived_time+L.get(index).burst_time));

                  s.add(in1);
                   s.add(E.get(index));
                  s.add(in2);

               }
               else{
                                  JTextField in1=new JTextField(Integer.toString(start));
                                  JTextField in2=new JTextField(Integer.toString(start+L.get(index).burst_time));
                                   s.add(E.get(index));
                                 s.add(in2);
               }
               
               
                
                s.setVisible(true);
               
                c++;
                L.get(index).done=1;
                m=m+1;
            }
            else
            {
                waiting += start - L.get(index).arrived_time;
                   L.get(index).done=1;
                         
                E.get(index).setText("P"+Integer.toString(c));
               E.get(index).setBounds(m, 0 ,5, 3);
               E.get(index).setPreferredSize(new Dimension(L.get(index).burst_time*20, 40));
                if(j==0){
                JTextField in1=new JTextField(Integer.toString(L.get(index).arrived_time));
                JTextField in2=new JTextField(Integer.toString(L.get(index).arrived_time+L.get(index).burst_time));

                  s.add(in1);
                  s.add(E.get(index));
                  s.add(in2);

               }
               else{
                                  JTextField in1=new JTextField(Integer.toString(start));
                                  JTextField in2=new JTextField(Integer.toString(start+L.get(index).burst_time));
                                   s.add(E.get(index));
                                 s.add(in2);
               }
                
                 s.setVisible(true);
                
                c++;
                L.get(index).done=1;
                 start += L.get(index).burst_time;

                counter++;
               
                m=m+1;
            }
                }
            }
             avg_waiting = waiting / counter;
                        JOptionPane.showMessageDialog(this, Integer.toString(avg_waiting) , "This is supposed to be the MessageBox title.", JOptionPane.ERROR_MESSAGE);


        }
        
        
        
        void SJF_nonpreemptive()
        {
            s.setSize(400,400);
            s.setLocationRelativeTo(null);
            BorderLayout b=new BorderLayout();
               FlowLayout f=new FlowLayout();
               GridLayout g=new GridLayout();
               s.setLayout(f);
               
            
            
            for (int j = 0; j < L.size(); j++){
                if(L.get(j).done==0){
                 
                
                 min = L.get(j).burst_time;
                 index=j;
                 for (int i = 0; i < L.size(); i++)
               {
                 if(L.get(i).done==0){
                  
                if (L.get(i).burst_time != min){
                
                
                if (L.get(i).burst_time < min)
                {
                    min = L.get(i).burst_time;
                    index = i;
                }


            
                  }
            }
               }
            
            if (j == 0)
            {
                start = L.get(index).arrived_time + L.get(index).burst_time;
                counter++;
                E.get(index).setText("P"+Integer.toString(c));
               E.get(index).setBounds(m, 0 ,1, 1);
               
               E.get(index).setPreferredSize(new Dimension(L.get(index).burst_time*20, 40));
               
               if(j==0){
                JTextField in1=new JTextField(Integer.toString(L.get(index).arrived_time));
                JTextField in2=new JTextField(Integer.toString(L.get(index).arrived_time+L.get(index).burst_time));

                  s.add(in1);
                   s.add(E.get(index));
                  s.add(in2);

               }
               else{
                                  JTextField in1=new JTextField(Integer.toString(start));
                                  JTextField in2=new JTextField(Integer.toString(start+L.get(index).burst_time));
                                   s.add(E.get(index));
                                 s.add(in2);
               }
               
               
                
                s.setVisible(true);
               
                c++;
                 L.get(index).done=1;
                m=m+1;
            }
            
            else
            {
                waiting += start - L.get(index).arrived_time;


                  E.get(index).setText("P"+Integer.toString(c));
               E.get(index).setBounds(m, 0 ,5, 3);
               E.get(index).setPreferredSize(new Dimension(L.get(index).burst_time*20, 40));
                if(j==0){
                JTextField in1=new JTextField(Integer.toString(L.get(index).arrived_time));
                JTextField in2=new JTextField(Integer.toString(L.get(index).arrived_time+L.get(index).burst_time));

                  s.add(in1);
                   s.add(E.get(index));

                  s.add(in2);

               }
               else{
                                  JTextField in1=new JTextField(Integer.toString(start));
                                  JTextField in2=new JTextField(Integer.toString(start+L.get(index).burst_time));
                                   s.add(E.get(index));
                                 s.add(in2);
               }
                
                 s.setVisible(true);
                
                c++;
                 L.get(index).done=1;
                 start += L.get(index).burst_time;

                counter++;
               
                m=m+1;
                
            }
                  
                
            
            }
            avg_waiting = waiting / counter;
            }
            
              for (int r = 0; r < L.size(); r++){
                  if(L.get(r).done==0){
                      waiting += start - L.get(r).arrived_time;
                     
                       counter++;


                  E.get(r).setText("P"+Integer.toString(c));
               E.get(r).setBounds(m, 0 ,5, 3);
               E.get(r).setPreferredSize(new Dimension(L.get(r).burst_time*20, 40));
                       JTextField in1=new JTextField(Integer.toString(start));
                                  JTextField in2=new JTextField(Integer.toString(start+L.get(r).burst_time));
                                   s.add(E.get(r));
                                 s.add(in2);
                                  avg_waiting = waiting / counter;

                      
                  }
                  

                  
              }
             JOptionPane.showMessageDialog(this, Integer.toString(avg_waiting) , "This is supposed to be the MessageBox title.", JOptionPane.ERROR_MESSAGE);

            

        }
        
        void SJF_preemptive(){
           
            int coun=0;
            
            int x=0;
            
            boolean check=true;
             
            
             s.setSize(400,400);
            s.setLocationRelativeTo(null);
            BorderLayout b=new BorderLayout();
               FlowLayout f=new FlowLayout();
               GridLayout g=new GridLayout();
               s.setLayout(f);
           
           
         
           
              while(coun!=L.size()){
                  
             
                  
                loop:
                if(x<L.size()){
                                JOptionPane.showMessageDialog(this, Integer.toString(x) , "This is supposed to be the MessageBox title.", JOptionPane.ERROR_MESSAGE);

                
                  if( L.get(x).done1==0){
                         
                     
                  
                  for(int y=x+1;y<=L.size();y++){
                      check=true;
                      
                      if( L.get(x).done1==0){
                         
                     
                      
                     while(check) {
                         m=m+10;
                      
                     L.get(x).counter= L.get(x).counter+1;
                     if(x==0){
                         
                         start = L.get(x).arrived_time + L.get(x).counter;
                         
                         E.get(x).setText("P"+Integer.toString(L.get(x).co));
                          E.get(x).setBounds(m, 0 ,5, 3);
                          E.get(x).setPreferredSize(new Dimension(L.get(x).counter*50, 40));
                         

                      
                       
                          if(L.get(x).counter==L.get(x).burst_time){
                               
                   
                          JTextField in1=new JTextField(Integer.toString(L.get(x).arrived_time));
                          JTextField in2=new JTextField(Integer.toString(L.get(x).arrived_time+L.get(x).counter));
                              
                              s.add(in1);
                              s.add(E.get(x));
                                          JOptionPane.showMessageDialog(this, "done" , "This is supposed to be the MessageBox title.", JOptionPane.ERROR_MESSAGE);

                              s.add(in2);
                               s.setVisible(true);
                           
                             
                              L.get(x).done1=1;
                              coun++;
                               m=m+10;
                              break loop;
                             
                              
                           }
                      if((L.get(x).counter+L.get(x).arrived_time)==L.get(y).arrived_time){
                          
                         
                          if((L.get(x).burst_time-(L.get(y).arrived_time-L.get(x).arrived_time))>L.get(y).burst_time){
                              
                   
                          JTextField in1=new JTextField(Integer.toString(L.get(x).arrived_time));
                          JTextField in2=new JTextField(Integer.toString(L.get(x).arrived_time+L.get(x).counter));
                          
                              s.add(in1);
                              s.add(E.get(x));
                              JOptionPane.showMessageDialog(this, "done" , "This is supposed to be the MessageBox title.", JOptionPane.ERROR_MESSAGE);

                              s.add(in2);
                              s.setVisible(true);
                           
                             
                              x++;
                            
                              m=m+10;
                              break loop;
                           
                       }
                       else{
                              
                   
                          JTextField in1=new JTextField(Integer.toString(L.get(x).arrived_time));
                          JTextField in2=new JTextField(Integer.toString(L.get(x).arrived_time+L.get(x).counter));
                              
                             s.add(in1);
                             s.add(E.get(x));
                             s.add(in2);
                              s.setVisible(true);
                           
                             
                             m=m+10;
                            
                             check=false;
                       }
 
                     }
                      
                     }
                     

                     else{
                         m=m+10;
                        
                        
                         
                         
                         
                
                          start += L.get(x).counter;
                  
                         
                     
                          if(L.get(x).counter==L.get(x).burst_time){
                             
                   
                          JTextField in2=new JTextField(Integer.toString(start+L.get(x).counter));
                              
                           
                             s.add(E.get(x));
                             s.add(in2);
                              s.setVisible(true);
                           
                            
                         
                              L.get(x).done1=1;
                              coun++;
                              x++;
                              m=m+10;
                              break loop;
                              
                           }
                     
                     if(y<L.size()){
                         
                         if((L.get(x).counter+L.get(x).arrived_time)==L.get(y).arrived_time&&x!=L.size()-1){
                             
                         
                     
                             if((L.get(x).burst_time-(L.get(y).arrived_time-L.get(x).arrived_time))>L.get(y).burst_time){
                                 
                            
                   
                   
                          JTextField in2=new JTextField(Integer.toString(start+L.get(x).counter));
                                 s.add(E.get(x));
                                 s.add(in2);
                                  s.setVisible(true);
                           
                                 
                                 m=m+10;
                                 x++;
                                 break loop;
                           
                           
                       }
                       else{
                                 
                   
                          JTextField in2=new JTextField(Integer.toString(start+L.get(x).counter));
                             s.add(E.get(x));
                             s.add(in2);
                            s.setVisible(true);
                           
                             m=m+10;
                              check=false;
                       }

                         
                     }
                     }
                     
                  }
                     
                  }
                  
                  
                  }
                  
                  }
                }
                }
                
                if(x==L.size()){
                    for(int v=0;v<L.size();v++){
                         if(L.get(v).done1==0){
                             
                        L.get(v).remain= L.get(v).burst_time- L.get(v).counter;
                           
                                }
                        
                    }
                    
          for(int J=0;J<L.size();J++){
             
                 
                if(L.get(J).done1==0){
                 min = L.get(J).remain;
                 index=J;

            for (int I = 0; I < L.size(); I++)
            {                if(L.get(I).done1==0){
                if (L.get(I).remain != min){
                

                if (L.get(I).remain < min)
                {
                    min = L.get(I).remain;
                    index = I;
                }
                }
            }

            }
               
             E.get(index).setText("P"+Integer.toString(L.get(index).co));
               E.get(index).setBounds(m, 0 ,5, 3);
               E.get(index).setPreferredSize(new Dimension(L.get(index).remain*20, 40));
                   
                   
                JTextField in2=new JTextField(Integer.toString(start+L.get(index).remain));
                
                   s.add(E.get(index));
                  s.add(in2);
                   s.setVisible(true);
                  start += L.get(index).remain;
                  L.get(index).done1=1;
                  coun++;
                   
                   m=m+10;
                  
            
            
                }
            
            
                }
                    
                    
                }
                
                
                
              }
              
              
              
              
              }
            
        
        
        
        
         
        void priority_nonpreemptive()
        {
             s.setSize(400,400);
            s.setLocationRelativeTo(null);
            BorderLayout b=new BorderLayout();
               FlowLayout f=new FlowLayout();
               GridLayout g=new GridLayout();
               s.setLayout(f);
               
            
            
            for (int j = 0; j < L.size(); j++){
                if(L.get(j).done==0){
                 
                
                 min = L.get(j).priority;
                 index=j;
                 for (int i = 0; i < L.size(); i++)
               {
                 if(L.get(i).done==0){
                  
                if (L.get(i).priority!= min){
                
                
                if (L.get(i).priority < min)
                {
                    min = L.get(i).priority;
                    index = i;
                }


            
                  }
            }
               }
            
            if (j == 0)
            {
                start = L.get(index).arrived_time + L.get(index).burst_time;
                counter++;
                E.get(index).setText("P"+Integer.toString(c));
               E.get(index).setBounds(m, 0 ,1, 1);
               
               E.get(index).setPreferredSize(new Dimension(L.get(index).burst_time*60, 40));
               
               if(j==0){
                JTextField in1=new JTextField(Integer.toString(L.get(index).arrived_time));
                JTextField in2=new JTextField(Integer.toString(L.get(index).arrived_time+L.get(index).burst_time));

                  s.add(in1);
                   s.add(E.get(index));
                  s.add(in2);

               }
               else{
                                  JTextField in1=new JTextField(Integer.toString(start));
                                  JTextField in2=new JTextField(Integer.toString(start+L.get(index).burst_time));
                                   s.add(E.get(index));
                                 s.add(in2);
               }
               
               
                
                s.setVisible(true);
               
                c++;
                 L.get(index).done=1;
                m=m+1;
            }
            
            else
            {
                waiting += (start - L.get(index).arrived_time);


                  E.get(index).setText("P"+Integer.toString(c));
               E.get(index).setBounds(m, 0 ,5, 3);
               E.get(index).setPreferredSize(new Dimension(L.get(index).burst_time*60, 40));
                if(j==0){
                JTextField in1=new JTextField(Integer.toString(L.get(index).arrived_time));
                JTextField in2=new JTextField(Integer.toString(L.get(index).arrived_time+L.get(index).burst_time));

                  s.add(in1);
                   s.add(E.get(index));

                  s.add(in2);

               }
               else{
                                  JTextField in1=new JTextField(Integer.toString(start));
                                  JTextField in2=new JTextField(Integer.toString(start+L.get(index).burst_time));
                                   s.add(E.get(index));
                                 s.add(in2);
               }
                
                 s.setVisible(true);
                
                c++;
                 L.get(index).done=1;
                 start += L.get(index).burst_time;

                counter++;
               
                m=m+1;
                
            }
                  
                
            
            }
            avg_waiting = waiting / counter;
            }
            
              for (int r = 0; r < L.size(); r++){
                  if(L.get(r).done==0){
                      waiting += (start - L.get(r).arrived_time);
                     
                       counter++;


                  E.get(r).setText("P"+Integer.toString(c));
               E.get(r).setBounds(m, 0 ,5, 3);
               E.get(r).setPreferredSize(new Dimension(L.get(r).burst_time*60, 40));
                       JTextField in1=new JTextField(Integer.toString(start));
                                  JTextField in2=new JTextField(Integer.toString(start+L.get(r).burst_time));
                                   s.add(E.get(r));
                                 s.add(in2);
                                  avg_waiting = waiting / counter;
                                  L.get(r).done=1;
                                  start += L.get(r).burst_time;

                      
                  }
                  

                  
              }
             JOptionPane.showMessageDialog(this, Integer.toString(avg_waiting) , "This is supposed to be the MessageBox title.", JOptionPane.ERROR_MESSAGE);

            
        }
        void round_robin()
        {
            s.setSize(400,400);
            s.setLocationRelativeTo(null);
            BorderLayout b=new BorderLayout();
               FlowLayout f=new FlowLayout();
               GridLayout g=new GridLayout();
               s.setLayout(f);
            int x=0;
            int y=0;
            while(in!=L.size()){
                             JOptionPane.showMessageDialog(this, Integer.toString(x) , "This is supposed to be the MessageBox title.", JOptionPane.ERROR_MESSAGE);

                if(x==L.size()){
                    x=0;
                }
                if(L.get(x).burst_time==0){
                    in++;
                }
                
               if(L.get(x).burst_time!=0) {
                   if(y==0){
                   JButton button2 = new JButton();
                    button2.setText("P"+Integer.toString(c));
               button2.setBounds(m, 0 ,5, 3);
               JTextField in1=new JTextField(Integer.toString(L.get(x).arrived_time));
               if(L.get(x).burst_time>L.get(x).Quantum){
               button2.setPreferredSize(new Dimension(L.get(x).Quantum*20, 40));
                JTextField in2=new JTextField(Integer.toString(L.get(x).arrived_time+L.get(x).Quantum));
                  s.add(in1);
                  s.add(button2);
                  s.add(in2);
                   start = L.get(x).arrived_time+L.get(x).Quantum;
                   L.get(x).burst_time=L.get(x).burst_time-L.get(x).Quantum;
                  
               }                

               else
               {
                   JButton button = new JButton();
                button.setPreferredSize(new Dimension(L.get(x).burst_time*20, 40));
               JTextField in2=new JTextField(Integer.toString(L.get(x).arrived_time+L.get(x).burst_time));
                  s.add(in1);
                  s.add(button);
                  s.add(in2);
                   start = L.get(x).arrived_time+L.get(x).burst_time;
                  L.get(x).burst_time=L.get(x).burst_time-L.get(x).burst_time;


               }
                
                

                  
                   s.setVisible(true);
                   y++;
                   x++;
                   
                  
                   
                   
                   
               }
                   else{
                          JButton button = new JButton();
                        button.setText("P"+Integer.toString(c));
               button.setBounds(m, 0 ,5, 3);
               JTextField in1=new JTextField(Integer.toString(L.get(x).arrived_time));
               if(L.get(x).burst_time>L.get(x).Quantum){
              button.setPreferredSize(new Dimension(L.get(x).Quantum*20, 40));
                JTextField in2=new JTextField(Integer.toString(L.get(x).arrived_time+L.get(x).Quantum));
                  
                  s.add(button);
                  s.add(in2);
                   start +=L.get(x).Quantum;
                    L.get(x).burst_time=L.get(x).burst_time-L.get(x).Quantum;
                  
               }                

               else
               {
                                  JButton button1 = new JButton();

               button1.setPreferredSize(new Dimension(L.get(x).burst_time*20, 40));
               JTextField in2=new JTextField(Integer.toString(L.get(x).arrived_time+L.get(x).burst_time));
                 
                  s.add(button1);
                  s.add(in2);
                   start+= L.get(x).burst_time;
                    L.get(x).burst_time=L.get(x).burst_time-L.get(x).burst_time;

               }
                
                

                  
                   s.setVisible(true);
                   y++;
                   x++;
                  
                   }
                       
                   }
                
            }

        }

        void s(){
            
             s.setSize(400,400);
            s.setLocationRelativeTo(null);
            BorderLayout b=new BorderLayout();
               FlowLayout f=new FlowLayout();
               GridLayout g=new GridLayout();
               s.setLayout(f);
               JButton button = new JButton();
              for(int i=0;i<3;i++){
                   
                   button.setBounds(i, 0, 5, 5);
                   button.setPreferredSize(new Dimension(20, 40));

                   
                   s.add(button);
                  
                    s.setVisible(true);
              }
               
        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem3 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem4 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem5 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem6 = new javax.swing.JRadioButtonMenuItem();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("CPU Scheduling");

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setText("jTextField2");

        jTextField3.setText("jTextField3");

        jTextField4.setText("jTextField4");

        jTextField5.setText("jTextField5");

        jLabel2.setText("Arriving Time");

        jLabel3.setText("Burst Time");

        jLabel4.setText("Priority");

        jLabel5.setText("Quantum");

        jLabel6.setText("Data");

        jButton1.setText("ADD Process");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("Algorithm");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("FCFS");
        jRadioButtonMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jRadioButtonMenuItem1);

        jRadioButtonMenuItem2.setSelected(true);
        jRadioButtonMenuItem2.setText("SJF_Nonpreemptive");
        jRadioButtonMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jRadioButtonMenuItem2);

        jRadioButtonMenuItem3.setSelected(true);
        jRadioButtonMenuItem3.setText("SJF_Preemptive");
        jRadioButtonMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jRadioButtonMenuItem3);

        jRadioButtonMenuItem4.setSelected(true);
        jRadioButtonMenuItem4.setText("Priority_Nonpreemptive");
        jRadioButtonMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jRadioButtonMenuItem4);

        jRadioButtonMenuItem5.setSelected(true);
        jRadioButtonMenuItem5.setText("Priority_preemptive");
        jMenu1.add(jRadioButtonMenuItem5);

        jRadioButtonMenuItem6.setSelected(true);
        jRadioButtonMenuItem6.setText("Round Robin");
        jRadioButtonMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jRadioButtonMenuItem6);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jButton1)
                .addContainerGap(229, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
int u=0;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        int ARR=Integer.parseInt(this.jTextField1.getText());
        int B=Integer.parseInt(this.jTextField2.getText());
        int P=Integer.parseInt(this.jTextField3.getText());
        int Q=Integer.parseInt(this.jTextField4.getText());
        int D=Integer.parseInt(this.jTextField5.getText());
        s();
     
        
        take_process(ARR,B,P,Q,D,0,0,0);
       
            JOptionPane.showMessageDialog(this, Integer.toString(L.get(u).data) , "This is supposed to be the MessageBox title.", JOptionPane.ERROR_MESSAGE);
       
        u=u+1;
         
                                        
        
    }//GEN-LAST:event_jButton1ActionPerformed
 
 
    private void jRadioButtonMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem1ActionPerformed
        // TODO add your handling code here:
        
         FCFS();

       
    }//GEN-LAST:event_jRadioButtonMenuItem1ActionPerformed

    private void jRadioButtonMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem2ActionPerformed
        // TODO add your handling code here:
        SJF_nonpreemptive();
    }//GEN-LAST:event_jRadioButtonMenuItem2ActionPerformed

    private void jRadioButtonMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem4ActionPerformed
        // TODO add your handling code here:
        priority_nonpreemptive();
    }//GEN-LAST:event_jRadioButtonMenuItem4ActionPerformed

    private void jRadioButtonMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem6ActionPerformed
        // TODO add your handling code here:
        round_robin();
    }//GEN-LAST:event_jRadioButtonMenuItem6ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jRadioButtonMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem3ActionPerformed
        // TODO add your handling code here:
        SJF_preemptive();
    }//GEN-LAST:event_jRadioButtonMenuItem3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
       
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem4;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem5;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
