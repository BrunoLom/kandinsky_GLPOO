package ihm;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.SOUTH;
import static javax.swing.SwingConstants.RIGHT;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import dao.SimpleTirage;
import dao.Tirage;

import org.apache.log4j.Logger;

public class AjouterTirageJDialog extends JDialog {

	    private static final Logger LOGGER = Logger.getLogger(AjouterTirageJDialog.class);
	    private ActionHandler actionHandler;

	    private JTextField boule1 = new JTextField(2);
	    private JTextField boule2 = new JTextField(2);
	    private JTextField boule3 = new JTextField(2);
	    private JTextField etoile1 = new JTextField(2);
	    private JTextField etoile2 = new JTextField(2);
	    private JTextField couleurs = new JTextField(15);
	    private JTextField poids = new JTextField(15);

	    private JButton ajouterButton = new JButton(new AjouterAction("Ajouter"));
	    private JButton annulerButton = new JButton(new AnnulerAction("Annuler"));

	    private static final int widthLabel = 100;
	    private static final int widthChamp = 200;
	    private static final int heightLigne = 20;

	    private static final int espace = 5;

	    private int y = 0;

	    private JPanel formPanel = new JPanel(null);
	    private JPanel buttonPanel = new JPanel();

	    private Tirage tirage;

	    public AjouterTirageJDialog(final ActionHandler actionHandler) {
	        this(actionHandler, null);

	    }

	    public AjouterTirageJDialog(final ActionHandler actionHandler, final Tirage tirage) {
	        super();

	        this.actionHandler = actionHandler;
	        this.tirage = tirage;

	        if (tirage == null) {
	            setTitle("Ajouter un chien");
	        } else {
	            setTitle("Modifier un chien");
	        }

	        // La taille est calculee a l'aide du panel (cf. addFormulaire).
	        // setPreferredSize(new Dimension(400, 250));
	        setModal(true);

	        // Formulaire
	        addFormulaire();
	        //preremplirFormulaire();

	        // Boutons
	        addBoutons();

	        pack();

	    }

	    private void addBoutons() {
	    	buttonPanel.add(ajouterButton);
	        buttonPanel.add(annulerButton);
	        add(buttonPanel, SOUTH);
	    }

	    private void addFormulaire() {
	        // Noms
	        ajouter("Boule 1", boule1);
	        ajouter("Boule 2", boule2);
	        ajouter("Boule 3", boule3);
	        ajouter("Etoile 1", etoile1);
	        ajouter("Etoile 2", etoile2);
	        

	       

	        // Si on avait voulu mettre des champs pour la date de naissance, on aurait pu faire comment suit :
	        // for(int i = 1; i <= 31;i++) {
	        // jour.addItem(i);
	        // }
	        //
	        // // Date de naissance
	        // for (int i = 1; i <= 31; i++) {
	        // jour.addItem(i);
	        // }
	        // for (int i = 1; i <= 12; i++) {
	        // mois.addItem(i);
	        // }
	        // for (int i = 2013; 1970 < i; i--) {
	        // annee.addItem(i);
	        // }
	        // ajouter("Naissance :", jour, mois, annee);

	        // Taille du panel
	        formPanel.setPreferredSize(new Dimension(3 * espace + widthLabel + widthChamp, y + espace));

	        // Ajout de tout le formulaire au centre
	        add(formPanel, CENTER);
	    }

	    private void ajouter(final String label, final JComponent champ) {
	        y += espace;

	        final JLabel l = new JLabel(label);
	        l.setBounds(espace, y, widthLabel, heightLigne);
	        l.setHorizontalAlignment(RIGHT);

	        champ.setBounds(2 * espace + widthLabel, y, widthChamp, heightLigne);

	        y += heightLigne;

	        formPanel.add(l);
	        formPanel.add(champ);
	    }

	    // private void ajouter(final String label, final JComponent champ1, final JComponent champ2, final JComponent champ3) {
	    // y += espace;
	    //
	    // final JLabel l = new JLabel(label);
	    // l.setBounds(espace, y, widthLabel, heightLigne);
	    // l.setHorizontalAlignment(RIGHT);
	    //
	    // int x = 2 * espace + widthLabel;
	    // champ1.setBounds(x, y, widthChampMultiple, heightLigne);
	    //
	    // x += espace + widthChampMultiple;
	    // champ2.setBounds(x, y, widthChampMultiple, heightLigne);
	    //
	    // x += espace + widthChampMultiple;
	    // champ3.setBounds(x, y, widthChampMultiple, heightLigne);
	    //
	    // y += heightLigne;
	    //
	    // formPanel.add(l);
	    // formPanel.add(champ1);
	    // formPanel.add(champ2);
	    // formPanel.add(champ3);
	    // }

	    private class AjouterAction extends AbstractAction {
	        /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public AjouterAction(String texte) {
	            super(texte);
	        }

	        public void actionPerformed(ActionEvent event) {
	            LOGGER.debug("Ajouter");

	            final SimpleTirage nouveauTirage = new SimpleTirage();

	            try {
	                actionHandler.process(Action.CREER, nouveauTirage);
	            } catch (TirageException exception) {
	                // TODO
	            }

	            // Fermeture de la fenêtre
	            AjouterTirageJDialog.this.closePopup();
	        }
	    }


	    private class AnnulerAction extends AbstractAction {
	        public AnnulerAction(String texte) {
	            super(texte);
	        }

	        public void actionPerformed(ActionEvent e) {
	            LOGGER.debug("Annuler");
	            // Ici pas besoin d'appeler le handler.
	            AjouterTirageJDialog.this.closePopup();
	        }
	    }

	    private void closePopup() {
	        // Fermeture de la fenetre.
	        dispose();
	    }

}
