import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Screen extends Frame implements ActionListener {

    //LABELS
    private Label fim1 = new Label("Final");
    private Label fim2 = new Label("Final");
    //BUTTONS
    private Button startButton = new Button("Iniciar");
    private Button cleanButton = new Button("Limpar");
    //JTEXTFIELD
    private JTextField maxValue = new JTextField();
    private JTextField priorityJTextField1 = new JTextField();
    private JTextField priorityJTextField2 = new JTextField();
    //LISTS
    public List leftList = new List();
    public List rightList = new List();
    //CONTAINER
    private Container northContainer = new Container();
    private Container centerContainer = new Container();
    private Container northContainerTop = new Container();
    //THREADS
    private Count count1;
    private Count count2;
    private Thread c1Thread;
    private Thread c2Thread;

    public void switchLabel1(){
        if (fim1.isVisible()) {
            fim1.setVisible(false);
        } else {
            fim1.setVisible(true);
        }
    }

    public void switchLabel2(){
        if (fim2.isVisible()) {
            fim2.setVisible(false);
        } else {
            fim2.setVisible(true);
        }
    }

    public Screen (String titulo, int largura, int altura, int colinic, int lininic){
        super(titulo);
        setSize(largura, altura);
        setLocation(colinic, lininic);
        setLayout(new BorderLayout());
        //NORTH CONTAINER
        northContainer.setLayout(new BorderLayout());
        northContainerTop.setLayout(new GridLayout(3, 2));

        northContainerTop.add(new Label("Máximo:"));
        northContainerTop.add(maxValue);
        northContainerTop.add(new Label("Prioridade 1:"));
        northContainerTop.add(priorityJTextField1);
        northContainerTop.add(new Label("Prioridade 2:"));
        northContainerTop.add(priorityJTextField2);
        
        //There's the need to correct the button size.
        northContainer.add(startButton, BorderLayout.SOUTH);
        northContainer.add(northContainerTop, BorderLayout.NORTH);

        //CENTER CONTAINER
        centerContainer.setLayout(new GridLayout(2, 2, 2, 30));
        centerContainer.add(leftList);
        centerContainer.add(rightList);
        centerContainer.add(fim1);
        centerContainer.add(fim2);
        fim1.setVisible(false);
        fim2.setVisible(false);

        //SOUTH CONTAINER
        add(cleanButton, BorderLayout.SOUTH);

        //SHOWING UP THE FORM
        add(northContainer, BorderLayout.NORTH);
        add(centerContainer, BorderLayout.CENTER);
        setVisible(true);

        startButton.addActionListener(this);
        cleanButton.addActionListener(this);

        count1 = new Count();
        count2 = new Count();
        c1Thread = new Thread(count1);
        c2Thread = new Thread(count2);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == startButton){
            count1.setValue(Integer.parseInt(maxValue.getText()));
            c1Thread.setName("Thread-1");
            c1Thread.setPriority(Integer.parseInt(priorityJTextField1.getText()));

            count2.setValue(Integer.parseInt(maxValue.getText()));
            c2Thread.setName("Thread-2");
            c2Thread.setPriority(Integer.parseInt(priorityJTextField2.getText()));

            c1Thread.start();
            c2Thread.start();

        } else if (e.getSource() == cleanButton){
            leftList.removeAll();
            rightList.removeAll();
        }
    }
}
