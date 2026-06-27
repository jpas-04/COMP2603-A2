import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Swing GUI for searching and viewing animals in a sanctuary.
 *
 * Layout:
 *   NORTH:  Search field, type combo box, injured checkbox, search button
 *   CENTER: Scrollable text area showing results
 *   SOUTH:  Status label showing match count
 */
public class SanctuaryGUI extends JFrame {
    private Sanctuary sanctuary;

        private JTextField nameField;
        private JComboBox<String> typeCombo;
        private JCheckBox injuredCheck;
        private JButton searchButton;
        private JTextArea resultArea;
        private JLabel statusLabel;

    public SanctuaryGUI() {
        super("Caribbean Wildlife Conservation Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);

        // TODO M9: Set layout to BorderLayout
        setLayout(new BorderLayout());
        // TODO M9: Build NORTH panel (FlowLayout)
        JPanel northPanel = new JPanel(new FlowLayout());
        northPanel.add(new JLabel("Search:"));
     
        //   Add JLabel "Search:", JTextField (14 columns), JLabel "Type:",
        nameField = new JTextField(14);
        northPanel.add(nameField);
        northPanel.add(new JLabel("Type:"));
        //   JComboBox with {"All","Bird","Reptile","Marine"},
        typeCombo = new JComboBox<>(new String[]{"All","Bird","Reptile","Marine"});
        northPanel.add(typeCombo);
        //   JCheckBox "Injured/Critical only", JButton "Search"
        injuredCheck = new JCheckBox("Injured/Critical only");
        northPanel.add(injuredCheck);
        searchButton = new JButton("Search");
        northPanel.add(searchButton);
        //   Add panel to NORTH
        add(northPanel,BorderLayout.NORTH);
        // TODO M9: Build CENTER
        //   Create JTextArea, set monospaced font, make non-editable
        resultArea = new JTextArea();
        resultArea.setFont(new Font(Font.MONOSPACED,Font.PLAIN,12));
        resultArea.setEditable(false);
        //   Wrap in JScrollPane, add to CENTER

        JScrollPane scrollPane = new JScrollPane(resultArea);
        add(scrollPane,BorderLayout.CENTER);
        // TODO M9: Build SOUTH
        //   Create JLabel "Ready", add to SOUTH
        statusLabel = new JLabel("Ready");
        add(statusLabel,BorderLayout.SOUTH);

        // TODO M11: Add ActionListener to searchButton that calls runSearch()
        searchButton.addActionListener(e -> runSearch());

        // TODO M11: Add KeyListener to nameField that calls runSearch() on keyReleased
        nameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e){
                runSearch();
            }
        });
        setLocationRelativeTo(null);
    }

    /**
     * Stores the Sanctuary to search over.
     * TODO M10: Implement setModel
     */
    public void setModel(Sanctuary s) {
        sanctuary = s;
        setTitle("Sanctuary - " + sanctuary.getName());
    }


    /**
     * Filters the sanctuary's animals based on the GUI controls and
     * displays matching results.
     *
     * TODO M11: Implement runSearch
     *
     * Steps:
     * 1. Get text from nameField (trim, convert to lowercase)
     * 2. Get selected type from typeCombo
     * 3. Get checkbox state from injuredCheck
     * 4. Loop through sanctuary's animals:
     *    - If text is non-empty, keep only animals whose species or nickname
     *      contains the text (case-insensitive)
     *    - If type is not "All", keep only matching type
     *    - If checkbox is selected, keep only "Injured" or "Critical" animals
     * 5. Build result string and set in resultArea
     * 6. Set statusLabel: "No matches", "1 result", or "N results"
     */
    private void runSearch() {
        // TODO M11: Implement filtering and display
        String searchText = nameField.getText().trim().toLowerCase();
        String selectText = (String)typeCombo.getSelectedItem();
        boolean injury = injuredCheck.isSelected();
        StringBuilder results = new StringBuilder();
        int count = 0;
        
        for(Animal animal : sanctuary.getAnimals()){
            if(!searchText.isEmpty()){
                boolean textMatch = animal.getSpecies().toLowerCase().contains(searchText) ||
                animal.getNickname().toLowerCase().contains(searchText);

                if(!textMatch){
                    continue;
                }
            }
            if (!selectText.equals("All") && !animal.getType().equals(selectText)){
                continue;
            }
            if(injury){
                String status = animal.getHealthStatus();
                if(!status.equals("Injured") && !status.equals("Critical")){
                    continue;
                }
            } 
            results.append(animal.toString()).append("\n");
            count+=1;
        }
        resultArea.setText(results.toString());
        if (count == 0){
            statusLabel.setText("No Matches");
        } else if (count == 1){
            statusLabel.setText("1 result");
        } else {
            statusLabel.setText(count + " Results");
        }

    }

    /**
     * Creates a demo sanctuary, populates it, and launches the GUI.
     *
     * TODO M12: Implement main method
     */
    public static void main(String[] args) {
        // TODO M12: Create Sanctuary, add animals, create GUI, wire model, show
      Sanctuary Caroni = new Sanctuary("Caroni Bird Sanctuary", "Trinidad", 20);
      Sanctuary Blue = new Sanctuary("Blue Lagoon Marine Park", "Jamaica", 15);
      Bird b = new Bird("Scarlet Ibis", "Ruby", "Trinidad", 0.35, "Healthy", 60.0, true);
      Bird c = new Bird("Scarlet Ibis", "Blaze", "Trinidad", 0.40, "Healthy", 58.0, true);
      Bird d = new Bird("Cocorico", "Dusty", "Trinidad", 0.25, "Injured", 30.0, true);
      Reptile r = new Reptile("Spectacled Caiman", "Brutus", "Trinidad", 45.0, "Healthy", false, 180.0);
      Reptile s = new Reptile("Green Anaconda", "Medusa", "Trinidad", 30.0, "Critical", false, 350.0);
      Marine m = new Marine("Leatherback Turtle", "Atlas", "Trinidad", 500.0,"Healthy",1200.0,8000);
      Bird e = new Bird("Doctor Bird", "Flash", "Jamaica", 0.01, "Healthy", 12.0, true);
      Marine n = new Marine("Hawksbill Turtle", "Shelly", "Jamaica", 80.0, "Injured", 50.0, 3000);
      Marine o = new Marine("Nurse Shark", "Gills", "Jamaica", 110.0, "Health", 75.0, 5000);
      Caroni.addAnimal(b);
      Caroni.addAnimal(c);
      Caroni.addAnimal(d);
      Caroni.addAnimal(r);
      Caroni.addAnimal(s);
      Caroni.addAnimal(m);
      Blue.addAnimal(e);
      Blue.addAnimal(n);
      Blue.addAnimal(o);

      SanctuaryGUI gui = new SanctuaryGUI();
      gui.setModel(Caroni);
      gui.setVisible(true);
    }
}
