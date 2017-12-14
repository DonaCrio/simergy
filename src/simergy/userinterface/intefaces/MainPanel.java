package simergy.userinterface.intefaces;

import javax.swing.JPanel;

import simergy.core.system.SimErgy;

public class MainPanel extends JPanel{

	private static final long serialVersionUID = 5447848031915306642L;
	
	private SimErgy sys;

	public MainPanel(SimErgy sys){
		super();
		this.sys = sys;
	}
}
