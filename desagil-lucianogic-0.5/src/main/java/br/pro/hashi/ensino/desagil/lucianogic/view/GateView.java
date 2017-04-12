package br.pro.hashi.ensino.desagil.lucianogic.view;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;

import br.pro.hashi.ensino.desagil.lucianogic.model.Gate;
import br.pro.hashi.ensino.desagil.lucianogic.model.LED;
import br.pro.hashi.ensino.desagil.lucianogic.model.Switch;


public class GateView extends FixedPanel implements ItemListener {

	// Necessario para serializar objetos desta classe.
	private static final long serialVersionUID = 1L;


	private Image image;

	private JCheckBox outBox;

	private Switch[] switches;
	private Gate gate;

	public GateView(Gate gate) {
		super(205, 180);

		this.gate = gate;

		image = loadImage(gate.toString());

		int size = gate.getSize();
		
		switches = new Switch[size];
						
		for(int i = 0; i < size; i++) {

			switches[i] = new Switch();

			gate.connect(switches[i], i);
		}

		outBox = new JCheckBox();

		outBox.setEnabled(false);

		add(outBox, 184, 60, 20, 20);

		outBox.setSelected(gate.read());
	}


	@Override
	public void itemStateChanged(ItemEvent event) {

		outBox.setSelected(gate.read());
	}


	// Necessario para carregar os arquivos de imagem.
	private Image loadImage(String filename) {
		URL url = getClass().getResource("/img/" + filename + ".png");
		ImageIcon icon = new ImageIcon(url);
		return icon.getImage();
	}


	@Override
	public void paintComponent(Graphics g) {
		// Evita bugs visuais em alguns sistemas operacionais.
		super.paintComponent(g);
		
		switches = new Switch[gate.getSize()];
		
		if(gate.getSize() == 1) {
		
			g.setColor(Color.BLACK);
			g.fillOval(0,65,15,15);
			g.setColor(Color.BLACK);
			g.drawLine(7,50,11,65);
			g.setColor(Color.BLACK);
			g.fillOval(5,47,7,7);
		}
		
		else {
			
			g.setColor(Color.BLACK);
			g.fillOval(0,45,15,15);
			g.setColor(Color.BLACK);
			g.drawLine(7,30,11,45);
			g.setColor(Color.BLACK);
			g.fillOval(5,27,7,7);
		
			g.setColor(Color.BLACK);
			g.fillOval(0,85,15,15);
			g.setColor(Color.BLACK);
			g.drawLine(7,70,11,85);
			g.setColor(Color.BLACK);
			g.fillOval(5,67,7,7);

		}
		
		g.drawImage(image, 10, 20, 184, 140, null);

		// Evita bugs visuais em alguns sistemas operacionais.
		getToolkit().sync();
    }


	public void mouseClicked(MouseEvent e) {
	    int screenX = e.getXOnScreen();
	    int screenY = e.getYOnScreen();
		if(gate.getSize() == 1) {
			if ( screenX>=0 && screenX<= 15 ) {
				if ( screenY>=15  && screenY<= 65){
					/* nao consegui utilizar o bloco a seguir fora da paintComponent
					 * pretendia alterar o sentido da alavanca com o clique
					g.setColor(Color.BLACK);
					g.fillOval(0,65,15,15);
					g.setColor(Color.BLACK);
					g.drawLine(7,50,11,65);
					g.setColor(Color.BLACK);
					g.fillOval(5,47,7,7);
					*/
	    	}}

    	
	}

}}
