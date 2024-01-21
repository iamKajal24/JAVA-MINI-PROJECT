import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class NotePad implements ActionListener{

	public static void main(String[] args) {
		new NotePad();
       
	}
	
	Font f =new Font("Arial",Font.PLAIN,30);
	JTextArea txtArea = new JTextArea();
	
	JScrollPane scroll =new JScrollPane(txtArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	JFrame jf = new JFrame();
	JMenuBar jmb = new JMenuBar();
	JMenu fileMenu = new JMenu("file");
	JMenu editMenu = new JMenu("Edit");
	JMenu FormatMenu = new JMenu("format");
	JMenu ViewMenu = new JMenu("View");
	JMenu HelpMenu = new JMenu("Help");
	
	
	
	JMenuItem fNew = new JMenuItem("New     Crtl+S");
	JMenuItem fOpen = new JMenuItem("Open   Crtl+O");
	JMenuItem fSave = new JMenuItem("Save   Crtl+S");
	JMenuItem fSaveAs = new JMenuItem("SaveAs");
	JMenuItem fPageSetup = new JMenuItem("Page Setup");
	JMenuItem fPrint = new JMenuItem("Print");
	JMenuItem fExit= new JMenuItem("Exit");
	
	
	JMenuItem eUndo = new JMenuItem("Undo");
	JMenuItem eCut = new JMenuItem("Cut");
	JMenuItem eCopy = new JMenuItem("Copy");
	JMenuItem ePaste = new JMenuItem("Paste");
	JMenuItem eDelete = new JMenuItem("Delete");
	JMenuItem eFind = new JMenuItem("Find");
	JMenuItem eFindNext = new JMenuItem("FindNext");
	JMenuItem eReplace = new JMenuItem("Replace");
	JMenuItem eGoto = new JMenuItem("Goto");
	JMenuItem eSelectAll = new JMenuItem("Select All");
	JMenuItem eDate = new JMenuItem("Date");
	
	JMenuItem forWordRap = new JMenuItem("Wrap Word");
	JMenuItem forfont = new JMenuItem("Font");
	
	JMenuItem vStatus = new JMenuItem("Status");
	
	JMenuItem hViewHelp = new JMenuItem("View Help");
	JMenuItem hAbout = new JMenuItem("About");
	
	public NotePad() {
		
		//fileMenutems
		fNew.addActionListener(this);
		fileMenu.add(fNew);
		fileMenu.add(fOpen);
		fileMenu.add(fSave);
		fileMenu.add(fSaveAs);
		fileMenu.add(fPageSetup);
		fileMenu.add(fPrint);
		fileMenu.add(fExit);
		
		//EditMenuItems
		editMenu.add(eUndo);
		editMenu.add(eCut);
		editMenu.add(eCopy);
		editMenu.add(ePaste);
		editMenu.add(eDelete);
		editMenu.add(eFind);
		editMenu.add(eFindNext);
		editMenu.add(eReplace);
		editMenu.add(eGoto);
		editMenu.add(eSelectAll);
		editMenu.add(eDate);
		
		//FormattingMenuItem Adding
		FormatMenu.add(forWordRap);
		FormatMenu.add(forfont);
		
		// ViewMenuItem Adding 
		
		ViewMenu.add(vStatus);
		
		//HelpMenuItem Adding 
		
		HelpMenu.add(hViewHelp);
		HelpMenu.add(hAbout);
		txtArea.setFont(f);
		txtArea.setLineWrap(true);
		txtArea.setWrapStyleWord(true);
		scroll.setSize(795,495);
		
		jmb.add(fileMenu);
		jmb.add(editMenu);
		jmb.add(FormatMenu);
		jmb.add(ViewMenu);
		jmb.add(HelpMenu);
		
		jf.add(scroll);
		jf.setJMenuBar(jmb);
		jf.setTitle("NotePad");
		jf.setSize(700,500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(fNew)) {
			JOptionPane.showMessageDialog(null, "My New is working");
			
		}
		
	}
	

}
