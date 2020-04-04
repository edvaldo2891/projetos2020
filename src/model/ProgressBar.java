package model;

import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.theme.ExperienceGreen;
import com.l2fprod.gui.plaf.skin.SkinLookAndFeel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.beans.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.frmLogin;

public class ProgressBar extends JPanel implements ActionListener, PropertyChangeListener {
    
    long tempoInicio = System.currentTimeMillis();  
    private static JFrame frame = new JFrame();
    private JProgressBar progressBar;
    private JButton startButton;
    private JTextArea taskOutput;
    private JLabel lblCarrega;
    private Task task;
    private static int progress = 0,temp=0;
    private static ImageIcon icone ;

    class Task extends SwingWorker<Void, Void> {
        /*
         * Main task. Executed in background thread.
         */
        @Override
        public Void doInBackground() {
            Random random = new Random();
            int progress = 0;
            //Initialize progress property.
            setProgress(0);
            //Sleep for at least one second to simulate "startup". (System.currentTimeMillis()-tempoInicio)
            try {
                Thread.sleep(1000 + random.nextInt(2000));
            } catch (InterruptedException ignore) {
                Logger.getLogger(ProgressBar.class.getName()).log(Level.SEVERE, null, ignore);
            }
            while (progress < 100) {
                //Sleep for up to one second.
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException ignore) {}
                //Make random progress.
                temp = (int)(System.currentTimeMillis()-tempoInicio)/50;
                progress += random.nextInt(temp);
                setProgress(Math.min(progress, 100));
                
            }
             if(progress >= 100){
                        try {
                               frmLogin main = new frmLogin();
                               setVisible(false);
                               main.setVisible(true);
                               if(progress >= 100)
                                          frame.dispose();      
                            } catch (Exception ex) {
                                Logger.getLogger(ProgressBar.class.getName()).log(Level.SEVERE, null, ex);
                            }
         }
            System.out.println("Valor da variavel temp(System.currentTimeMillis()-tempoInicio)/50): "+temp);    
            return null;
            
                              
        }
     public void done() {
            Toolkit.getDefaultToolkit().beep();
            startButton.setEnabled(true);
            taskOutput.append("Done!\n");
        }
    }

    public ProgressBar() throws Exception {
        super(new BorderLayout());
        LookAndFeels();
        icone = new ImageIcon("C:/prjVenalUrbano/imagens/House-1-64.png");
        frame.setIconImage(icone.getImage());	
        startButton = new JButton("Start");
        lblCarrega = new JLabel("Carregando..."); 
        startButton.setActionCommand("start");
        startButton.addActionListener(this);
        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setForeground(new java.awt.Color(153,189,90));
        progressBar.setStringPainted(true); 
        taskOutput = new JTextArea(5, 20);
        taskOutput.setMargin(new Insets(5,5,5,5));
        taskOutput.setEditable(false);

        JPanel panel = new JPanel();  
        panel.add(lblCarrega);
        panel.add(progressBar);  
        panel.setBackground(Color.white);
        add(panel, BorderLayout.PAGE_START);
        add(new JScrollPane(taskOutput), BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30)); 
        executarBarra();   
        System.out.println("Tempo Total de execução: "+(System.currentTimeMillis()-tempoInicio));  
        
    }
 public void actionPerformed(ActionEvent evt) {
        progressBar.setIndeterminate(true);
        startButton.setEnabled(false);
        task = new Task();
        task.addPropertyChangeListener(this);
        task.execute();
    }

    public void propertyChange(PropertyChangeEvent evt) {
        if ("progress" == evt.getPropertyName()){   
            progress = (Integer) evt.getNewValue();
            progressBar.setIndeterminate(false);
            progressBar.setValue(progress);
            taskOutput.append(String.format(
                        "Carregamento %d%% concluído.\n", progress));
        }
    }
    public void executarBarra(){
        progressBar.setIndeterminate(true);
        startButton.setEnabled(false);
        //Instances of javax.swing.SwingWorker are not reusuable, so
        //we create new instances as needed.
        task = new Task();
        task.addPropertyChangeListener(this);
        task.execute();
    }

    public static void createAndShowGUI() throws Exception {
        UIManager.put("TabbedPane.contentOpaque", Boolean.FALSE);
        LookAndFeels();
        icone = new ImageIcon("C:/prjVenalUrbano/imagens/House-1-64.png");
        frame.setIconImage(icone.getImage());	
        frame.setUndecorated(true); 
        JComponent newContentPane = new ProgressBar();
        newContentPane.setBackground(Color.white);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    public static void LookAndFeels() throws Exception{
        try{
            SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:/prjVenalUrbano/temas/chaNinja-Bluethemepack.zip"));
            UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
        }catch(UnsupportedLookAndFeelException ex){
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {                        
                    createAndShowGUI();
                } catch (Exception ex) {
                    Logger.getLogger(ProgressBar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
}
