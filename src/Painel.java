import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Painel extends Frame implements ActionListener {
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
    private Count count1 = new Count();
    private Count count2 = new Count();
    private Thread t1 = new Thread(count1);
    private Thread t2 = new Thread(count2);

    public Painel (String titulo, int largura, int altura, int colinic, int lininic){
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
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == startButton){
            count1.setValue(Integer.parseInt(maxValue.getText()));
            count2.setValue(Integer.parseInt(maxValue.getText()));
            
            t1.setPriority(Integer.parseInt(priorityJTextField1.getText()));
            t2.setPriority(Integer.parseInt(priorityJTextField2.getText()));
            t1.start();
            t2.start();

            leftList.;

        } else if (e.getSource() == cleanButton){

        }
    }
}
