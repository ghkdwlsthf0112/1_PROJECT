package gui.layout.main.admin_window.actions;

import java.awt.event.MouseListener;

import javax.swing.JTable;
import javax.swing.JTextPane;

import gui.layout.main.admin_window.AdminChkResv;
import oracle.jdbc.logging.annotations.StringBlinder;

public class SelectResMouseEvent implements MouseListener{
	
	AdminChkResv mainFrame;
	StringBuilder selectRes;
	JTextPane selectRoomInfo;
	JTable table;
	
	
	public SelectResMouseEvent(AdminChkResv mainFrame) {
		this.mainFrame = mainFrame;
		this.selectRes = mainFrame.selectRes;
		this.selectRoomInfo = mainFrame.selectRoomInfo;
		this.table = mainFrame.table;
	}
	
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		int row = table.getSelectedRow();
		int col = table.getSelectedColumn();
//		for (int i = 0; i < table.getColumnCount(); i++) {
//			System.out.print(table.getModel().getValueAt(row, i) + "\t");
//		}
		selectRes.setLength(0);
		selectRes.append(table.getModel().getValueAt(row, 0).toString());
//		System.out.println("확인"+selectRes);
		selectRoomInfo.setText("예약번호 : "+selectRes+"\t 객실번호 : "+table.getModel().getValueAt(row, 2).toString());
		
	}
	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
