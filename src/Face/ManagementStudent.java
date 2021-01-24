package Face;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;


import Dao.StudentExamDao;

import modell.StudentExam;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class ManagementStudent extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTimkiem;
	private JTable table;
	private JScrollPane scrollableTextArea ;
	private JTextField txtID;
	private JTextField txtTimKiem; 
	private JComboBox<Object> cbNgay; 
	private JButton btnTimkiem; 
	private JComboBox<Object> cbThang; 
	private JComboBox<Object> cbNam; 
	private JComboBox<Object> cbOptionSort; 
	private  DefaultTableModel model; 
	private String optionSort; 
	private String option[] = {
			"Mặc định", 
			"Sắp xếp theo giới tính", 
			"Sắp xếp theo khu vực", 
			"Sắp xếp theo đối tượng"
	}; 
	private String ngay[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", 
			"19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"
	}; 
	private String gioitinh[] = {"Nam", "Nữ"}; 
	private String thang[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}; 
	private String nam[] = {"1980","1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990","1991",  "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002"};
	private JTextField txtDiachi;
	private String diemcong[] = {"0.5", "1.0", "1.5", "2", "2.5"};  
	private int mId; 
	private String mHoten;
	private int mNgay;  
	private int mThang;   
	private int mNam;
	private String mDate;
	private String mDiachi; 
	private String mTruongTH; 
	private String mTruongCS; 
	private String mGioitinh; 
	private float mAnh; 
	private float mVan; 
	private float mToan; 
	private float mDiemcong; 
	private String mPhongthi; 
	private String mCumthi; 
	
	private JTextField txtHoten;
	private JTextField txtTruongCS;
	private JTextField txtTruongTH;
	private JTextField txtPhongthi;
	private JTextField txtCumthi;
	private JLabel lblNewLabel_11;
	private JComboBox cbGT;
	private JLabel lblNewLabel_12;
	private JComboBox cbDiemcong;
	private JLabel lblNewLabel_13;
	private JTextField txtDiemtoan;
	private JLabel lblNewLabel_14;
	private JTextField txtDiemvan;
	private JLabel lblNewLabel_15;
	private JTextField txtDiemanh;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnClear;
	private StudentExam studentExam; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagementStudent frame = new ManagementStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManagementStudent() {
		setTitle("Qu\u1EA3n l\u00ED sinh vi\u00EAn thi vao lop 10 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 750);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Ph\u1EA7n m\u1EC1m qu\u1EA3n l\u00ED thi v\u00E0o l\u1EDBp 10");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblNewLabel_1 = new JLabel("");
		
		txtTimkiem = new JTextField();
		txtTimkiem.setColumns(10);
		btnTimkiem = new JButton("T\u00ECm ki\u1EBFm ");
		btnTimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String timkiem = txtTimkiem.getText(); 
				funTimKiem(timkiem);
				
			}

			
		});
		String col[] = {"ID", "Họ tên","Giới Tính", "Ngày sinh ", "Địa chỉ", "Trường Cơ Sở", "Trường Trung học", "Cụm Thi", "Phòng thi", "Điểm cộng", "Điểm toán", "Điểm văn ", "Điểm anh", "Điểm Tổng"};
		String data[][] = {};
		model = new DefaultTableModel(data,col);
		table = new JTable(model);
		
		/*
		 * table.getSelectionModel().addListSelectionListener(new
		 * ListSelectionListener() {
		 * 
		 * @Override public void valueChanged(ListSelectionEvent e) {
		 * getDataFromTable(); }
		 * 
		 * });
		 */
		 
		table.addMouseListener((MouseListener) new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				 getDataFromTable(); 
			}
		});
		scrollableTextArea = new JScrollPane(table);
		scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
	    scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("H\u1ECD t\u00EAn");
		
		JLabel lblNewLabel_4 = new JLabel("Ng\u00E0y sinh");
		
		cbNgay = new JComboBox<Object>(ngay);
		
		cbThang = new JComboBox<Object>(thang);
		 
		
		cbNam = new JComboBox<Object>(nam);
		
		JLabel lblNewLabel_5 = new JLabel("\u0110\u1ECBa ch\u1EC9");
		
		txtDiachi = new JTextField();
		txtDiachi.setColumns(10);
		
		cbOptionSort = new JComboBox<Object>(option);
		cbOptionSort.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sort();
			}
		});
		
		txtHoten = new JTextField();
		txtHoten.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Th\u00F4ng tin sinh vi\u00EAn ");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_6.setForeground(Color.RED);
		
		JLabel lblNewLabel_7 = new JLabel("Tr\u01B0\u1EDDng THCS");
		
		txtTruongCS = new JTextField();
		txtTruongCS.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Tr\u01B0\u1EDDng THPT");
		
		txtTruongTH = new JTextField();
		txtTruongTH.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Ph\u00F2ng thi");
		
		txtPhongthi = new JTextField();
		txtPhongthi.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("C\u1EE5m thi");
		
		txtCumthi = new JTextField();
		txtCumthi.setColumns(10);
		
		lblNewLabel_11 = new JLabel("Gi\u1EDBi t\u00EDnh");
		
		cbGT = new JComboBox<Object>(gioitinh);
		
		lblNewLabel_12 = new JLabel("Di\u1EC3m c\u1ED9ng");
		
		cbDiemcong = new JComboBox<Object>(diemcong);
		
		lblNewLabel_13 = new JLabel("\u0110i\u1EC3m to\u00E1n ");
		
		txtDiemtoan = new JTextField();
		txtDiemtoan.setColumns(10);
		
		lblNewLabel_14 = new JLabel("\u0110i\u1EC3m v\u0103n ");
		
		txtDiemvan = new JTextField();
		txtDiemvan.setColumns(10);
		
		lblNewLabel_15 = new JLabel("\u0110i\u1EC3m anh");
		
		txtDiemanh = new JTextField();
		txtDiemanh.setColumns(10);
		
		btnThem = new JButton("Th\u00EAm ");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					insertData();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		btnXoa = new JButton("X\u00F3a");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		
		btnSua = new JButton("S\u1EEDa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearData();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(380)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(488)
									.addComponent(txtTimkiem, GroupLayout.PREFERRED_SIZE, 535, GroupLayout.PREFERRED_SIZE)
									.addGap(32)
									.addComponent(btnTimkiem)
									.addGap(18)
									.addComponent(cbOptionSort, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
															.addGroup(gl_contentPane.createSequentialGroup()
																.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																	.addGroup(gl_contentPane.createSequentialGroup()
																		.addComponent(lblNewLabel_9)
																		.addGap(32)
																		.addComponent(txtPhongthi))
																	.addGroup(gl_contentPane.createSequentialGroup()
																		.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
																			.addComponent(lblNewLabel_8)
																			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																				.addComponent(lblNewLabel_5)
																				.addComponent(lblNewLabel_7)
																				.addComponent(lblNewLabel_4)
																				.addComponent(lblNewLabel_3)
																				.addComponent(lblNewLabel_11)
																				.addComponent(lblNewLabel_2)))
																		.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
																			.addGroup(gl_contentPane.createSequentialGroup()
																				.addGap(14)
																				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																					.addGroup(gl_contentPane.createSequentialGroup()
																						.addComponent(cbNgay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																						.addGap(18)
																						.addComponent(cbThang, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
																						.addComponent(cbNam, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
																					.addComponent(txtDiachi, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
																					.addComponent(txtTruongCS, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
																					.addComponent(txtTruongTH, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
																					.addComponent(cbGT, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
																			.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
																				.addPreferredGap(ComponentPlacement.RELATED)
																				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																					.addComponent(txtID, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
																					.addComponent(txtHoten, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)))))
																	.addGroup(gl_contentPane.createSequentialGroup()
																		.addComponent(lblNewLabel_10)
																		.addGap(43)
																		.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																			.addComponent(cbDiemcong, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
																			.addComponent(txtCumthi, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
																			.addComponent(txtDiemtoan, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
																			.addComponent(txtDiemvan, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
																			.addComponent(txtDiemanh, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))))
																.addGap(18))
															.addGroup(gl_contentPane.createSequentialGroup()
																.addGap(86)
																.addComponent(lblNewLabel_6)
																.addPreferredGap(ComponentPlacement.RELATED)))
														.addGroup(gl_contentPane.createSequentialGroup()
															.addComponent(lblNewLabel_12)
															.addPreferredGap(ComponentPlacement.RELATED)))
													.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(lblNewLabel_13)
														.addPreferredGap(ComponentPlacement.RELATED)))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(lblNewLabel_14)
													.addPreferredGap(ComponentPlacement.RELATED)))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblNewLabel_15)
												.addPreferredGap(ComponentPlacement.RELATED)))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(btnThem)
												.addComponent(btnSua))
											.addGap(98)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(btnClear)
												.addComponent(btnXoa))
											.addGap(134)))
									.addComponent(scrollableTextArea, GroupLayout.PREFERRED_SIZE, 948, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(478)
							.addComponent(lblNewLabel)))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtTimkiem, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTimkiem, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbOptionSort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(72)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_2)
								.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_3)
								.addComponent(txtHoten, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_4)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(cbGT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_11))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(cbNgay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(cbThang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(cbNam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_5)
								.addComponent(txtDiachi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_7)
								.addComponent(txtTruongCS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_8)
								.addComponent(txtTruongTH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_9)
								.addComponent(txtPhongthi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtCumthi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_10))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_12)
								.addComponent(cbDiemcong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_13)
								.addComponent(txtDiemtoan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_14)
								.addComponent(txtDiemvan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_15)
								.addComponent(txtDiemanh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(scrollableTextArea, GroupLayout.PREFERRED_SIZE, 525, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_6)
									.addPreferredGap(ComponentPlacement.RELATED, 455, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnThem)
										.addComponent(btnXoa))
									.addGap(26)))))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSua)
						.addComponent(btnClear))
					.addGap(36))
		);
		contentPane.setLayout(gl_contentPane);
		showData();
	}
	@SuppressWarnings("unused")
	private void showData() {
		optionSort = (String) cbOptionSort.getItemAt(cbOptionSort.getSelectedIndex()); 
		List<StudentExam> listStudentExamDaos = StudentExamDao.getData(optionSort); 
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] rowObjects = new Object[17];
		for(int i = 0; i < listStudentExamDaos.size(); i++) {
			rowObjects[0] = listStudentExamDaos.get(i).getId(); 
			rowObjects[1] = listStudentExamDaos.get(i).getHoten(); 
			rowObjects[2] = listStudentExamDaos.get(i).getGioitinh(); 
			rowObjects[3] = listStudentExamDaos.get(i).getNgaysinh(); 
			rowObjects[4] = listStudentExamDaos.get(i).getDiachi(); 
			rowObjects[5] = listStudentExamDaos.get(i).getTruongCS(); 
			rowObjects[6] = listStudentExamDaos.get(i).getTruongTH(); 
			rowObjects[7] = listStudentExamDaos.get(i).getCumthi(); 
			rowObjects[8] = listStudentExamDaos.get(i).getPhongthi();  
			rowObjects[9] = listStudentExamDaos.get(i).getDiemcong(); 
			rowObjects[10] = listStudentExamDaos.get(i).getDiemtoan();
			rowObjects[11] = listStudentExamDaos.get(i).getDiemvan(); 
			rowObjects[12] = listStudentExamDaos.get(i).getDiemanh();
			rowObjects[13] = listStudentExamDaos.get(i).diemTong();  
			model.addRow(rowObjects);
		}
	}
	private void insertData() throws ParseException {
		getValueTxt();
		if (!mHoten.equals("")) {
			int isInsertData = StudentExamDao.insertData(studentExam);
			if(isInsertData >0) {
				 JOptionPane.showMessageDialog(null,"Thêm dữ liệu thành công!");  
			}
			else {
				 JOptionPane.showMessageDialog(null,"Lỗi!");  
				
			}
		}
		else {
			JOptionPane.showMessageDialog(null,"Thêm các trường đầy đủ!");  
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel(); 
		refeshTable(model);
		 
	}
	private void getValueTxt() {
		mHoten = txtHoten.getText(); 
		mDate = cbNgay.getItemAt(cbNgay.getSelectedIndex())+"-" +cbThang.getItemAt(cbThang.getSelectedIndex()) +"-" +cbNam.getItemAt(cbNam.getSelectedIndex());
		mDiachi = txtDiachi.getText(); 
		mGioitinh = (String) cbGT.getItemAt(cbGT.getSelectedIndex()); 
		mToan = Float.parseFloat(txtDiemtoan.getText()); 
		mVan =Float.parseFloat(txtDiemvan.getText()); 
		mAnh =Float.parseFloat(txtDiemanh.getText()); 
		mDiemcong = Float.parseFloat((String) cbDiemcong.getItemAt(cbDiemcong.getSelectedIndex())); 
		mTruongCS = txtTruongCS.getText(); 
		mTruongTH = txtTruongTH.getText(); 
		mCumthi = txtCumthi.getText(); 
		mPhongthi = txtPhongthi.getText();
		studentExam = new StudentExam(mHoten, mDiachi, mDiemcong, mTruongCS, mTruongTH, mDate, mGioitinh, mCumthi, mPhongthi, mAnh, mToan, mVan); 
	}

	
	private void getDataFromTable() {
		System.out.println("hello");
		int index = table.getSelectedRow(); 
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel(); 
		txtID.setText(model.getValueAt(index, 0).toString());
		txtHoten.setText(model.getValueAt(index, 1).toString());
		cbGT.setSelectedItem(model.getValueAt(index, 2).toString());
		mDate = model.getValueAt(index, 3).toString();
		String[] splits = mDate.split("-");
		cbNgay.setSelectedItem(splits[0].toString());
		cbThang.setSelectedItem(splits[1].toString());
		cbNam.setSelectedItem(splits[2].toString());
		txtDiachi.setText(model.getValueAt(index, 4).toString());
		txtTruongCS.setText(model.getValueAt(index,5).toString());
		txtTruongTH.setText(model.getValueAt(index,6).toString());
		txtCumthi.setText(model.getValueAt(index,7).toString());
		txtPhongthi.setText(model.getValueAt(index,8).toString());
		cbDiemcong.setSelectedItem(model.getValueAt(index,9).toString());
		txtDiemtoan.setText(model.getValueAt(index,10).toString());
		txtDiemvan.setText(model.getValueAt(index,11).toString());
		txtDiemanh.setText(model.getValueAt(index,12).toString());
	}
	
	private void clearData() {
		cbNgay.setSelectedIndex(0);
		cbThang.setSelectedIndex(0);
		cbNam.setSelectedIndex(0);
		txtDiachi.setText("");
		txtTruongCS.setText("");
		txtTruongTH.setText("");
		txtCumthi.setText("");
		txtPhongthi.setText("");
		cbDiemcong.setSelectedIndex(0);
		txtDiemtoan.setText("");
		txtDiemvan.setText("");
		txtDiemanh.setText("");
	}
	private void delete() {
		mId = Integer.parseInt(txtID.getText());
		int result = StudentExamDao.delete(mId); 
		if (result > 0) {
			JOptionPane.showMessageDialog(null,"Xóa dữ liệu thành công!");  
		}
		else {
			JOptionPane.showMessageDialog(null,"Lỗi!");  
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel(); 
		refeshTable(model);
		 
	}
	private void update() {
		mId = Integer.parseInt(txtID.getText());
		getValueTxt();
		studentExam = new StudentExam(mId, mHoten, mDiachi, mDiemcong, mTruongCS, mTruongTH, mDate, mGioitinh, mCumthi, mPhongthi, mAnh, mToan, mVan) ; 
		int result = StudentExamDao.update(studentExam);  
		if (result > 0) {
			JOptionPane.showMessageDialog(null,"Sửa dữ liệu thành công!");  
		}
		else {
			JOptionPane.showMessageDialog(null,"Lỗi!");  
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel(); 
		refeshTable(model);
	}
	private void refeshTable(DefaultTableModel model) {
		clearData();
		model.setRowCount(0);
		showData();
	}
	private void funTimKiem(String timkiem) {
		optionSort = (String) cbOptionSort.getItemAt(cbOptionSort.getSelectedIndex()); 
		List<StudentExam> listStudentExamDaos = StudentExamDao.getData(optionSort); 
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		Object[] rowObjects = new Object[14];
		for(int i = 0; i < listStudentExamDaos.size(); i++) {
			rowObjects[0] = listStudentExamDaos.get(i).getId(); 
			rowObjects[1] = listStudentExamDaos.get(i).getHoten(); 
			rowObjects[2] = listStudentExamDaos.get(i).getGioitinh(); 
			rowObjects[3] = listStudentExamDaos.get(i).getNgaysinh(); 
			rowObjects[4] = listStudentExamDaos.get(i).getDiachi(); 
			rowObjects[5] = listStudentExamDaos.get(i).getTruongCS(); 
			rowObjects[6] = listStudentExamDaos.get(i).getTruongTH(); 
			rowObjects[7] = listStudentExamDaos.get(i).getCumthi(); 
			rowObjects[8] = listStudentExamDaos.get(i).getPhongthi();  
			rowObjects[9] = listStudentExamDaos.get(i).getDiemcong(); 
			rowObjects[10] = listStudentExamDaos.get(i).getDiemtoan();
			rowObjects[11] = listStudentExamDaos.get(i).getDiemvan(); 
			rowObjects[12] = listStudentExamDaos.get(i).getDiemanh();
			rowObjects[13] = listStudentExamDaos.get(i).diemTong();  
			if (listStudentExamDaos.get(i).getHoten().contains(timkiem) || listStudentExamDaos.get(i).getDiachi().contains(timkiem)
					|| listStudentExamDaos.get(i).getGioitinh().contains(timkiem) || listStudentExamDaos.get(i).getTruongCS().contains(timkiem)
					|| listStudentExamDaos.get(i).getTruongTH().contains(timkiem)) {
				model.addRow(rowObjects);
			}
			
		}
		
	}
	private void sort() {
		DefaultTableModel model = (DefaultTableModel) table.getModel(); 
		refeshTable(model);
	}
}
