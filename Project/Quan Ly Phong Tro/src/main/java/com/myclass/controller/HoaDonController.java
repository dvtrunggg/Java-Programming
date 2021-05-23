package com.myclass.controller;

import com.myclass.dao.DonGiaDao;
import com.myclass.dto.HoaDonDto;
import com.myclass.dto.HoaDonDto;
import com.myclass.dto.PhongTroDto;
import com.myclass.entity.HoaDonStatus;
import com.myclass.service.impl.HoaDonServiceImpl;
import com.myclass.service.impl.HoaDonStatusServiceImpl;
import com.myclass.service.impl.KhachThueServiceImpl;
import com.myclass.service.impl.PhongTroServiceImpl;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HoaDonController {

    private String action;
    private JButton btnDelete;
    private JButton btnSubmit;

    private JComboBox jcbTenPhong;
    private JDateChooser jdcStartDate;
    private JDateChooser jdcEndDate;
    private JLabel jlbGiaDien;
    private JLabel jlbGiaNuoc;
    private JLabel jlbGiaPhong;
    private JTextField jtfSoDien;
    private JTextField jtfSoNuoc;
    private JLabel jlbTienPhong;
    private JComboBox jcbTinhTrang;

    private JLabel jlbMsg;
    private JButton btnXuatHoaDon;

    private HoaDonDto hoaDon;

    private HoaDonStatusServiceImpl hoaDonStatusService;
    private PhongTroServiceImpl phongTroService;
    private HoaDonServiceImpl hoaDonService;

    public HoaDonController(String action, JButton btnDelete, JButton btnSubmit, JComboBox jcbTenPhong, JDateChooser jdcStartDate, JDateChooser jdcEndDate, JLabel jlbGiaDien, JLabel jlbGiaNuoc, JLabel jlbGiaPhong, JTextField jtfSoDien, JTextField jtfSoNuoc, JLabel jlbTienPhong, JComboBox jcbTinhTrang, JLabel jlbMsg, JButton btnXuatHoaDon) {
        this.action = action;
        this.btnDelete = btnDelete;
        this.btnSubmit = btnSubmit;
        this.jcbTenPhong = jcbTenPhong;
        this.jdcStartDate = jdcStartDate;
        this.jdcEndDate = jdcEndDate;
        this.jlbGiaDien = jlbGiaDien;
        this.jlbGiaNuoc = jlbGiaNuoc;
        this.jlbGiaPhong = jlbGiaPhong;
        this.jtfSoDien = jtfSoDien;
        this.jtfSoNuoc = jtfSoNuoc;
        this.jlbTienPhong = jlbTienPhong;
        this.jcbTinhTrang = jcbTinhTrang;
        this.jlbMsg = jlbMsg;
        this.btnXuatHoaDon = btnXuatHoaDon;

        hoaDonStatusService = new HoaDonStatusServiceImpl();
        phongTroService = new PhongTroServiceImpl();
        hoaDonService = new HoaDonServiceImpl();
    }

    public void setView(HoaDonDto hoaDon) throws ParseException {
        // set ten phong
        int indexOfPhong = 0;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        List<PhongTroDto> dsPhong = phongTroService.getAll();
        for (PhongTroDto phong : dsPhong) {
            model.addElement(phong.getTenPhong());
        }
        jcbTenPhong.setModel(model);

        // set status 
        int indexOfStatus = 0;
        DefaultComboBoxModel modelSt = new DefaultComboBoxModel();
        List<HoaDonStatus> dsStatus = hoaDonStatusService.getAll();
        for (HoaDonStatus status : dsStatus) {
            modelSt.addElement(status.getName());
        }
        jcbTinhTrang.setModel(modelSt);

        if (action.equals("update")) {

            this.hoaDon = hoaDon;
            // set data
            jtfSoDien.setText(String.valueOf(hoaDon.getSoDien()));
            jtfSoNuoc.setText(String.valueOf(hoaDon.getSoNuoc()));
            jlbGiaDien.setText(String.valueOf(hoaDon.getGiaDien()));
            jlbGiaNuoc.setText(String.valueOf(hoaDon.getGiaNuoc()));
            jlbGiaPhong.setText(String.valueOf(hoaDon.getGiaPhong()));
            jlbTienPhong.setText(String.valueOf(hoaDon.getTienPhong()));
            jdcStartDate.setDate(hoaDon.getStartDate());
            jdcEndDate.setDate(hoaDon.getEndDate());

            // set ten phong
            for (PhongTroDto phong : dsPhong) {
                if (hoaDon.getTenPhong().equals(phong.getTenPhong())) {
                    indexOfPhong = dsPhong.indexOf(phong);
                    break;
                }
            }
            jcbTenPhong.setSelectedIndex(indexOfPhong);

            // set tinh trang hoa don 
            for (HoaDonStatus status : dsStatus) {
                if (hoaDon.getStatusName().equals(status.getName())) {
                    indexOfPhong = dsPhong.indexOf(status);
                    break;
                }
            }
            jcbTinhTrang.setSelectedIndex(indexOfStatus);

        }

        if (action.equals("insert")) {
            btnXuatHoaDon.setVisible(false);
            btnDelete.setVisible(false);
            this.hoaDon = new HoaDonDto();
            this.hoaDon = new HoaDonDto();
            // set tien phong , gia dien , gia nuoc
            DonGiaDao donGia = new DonGiaDao();
            int giaDien = donGia.getDonGia().getGiaDien();
            int giaNuoc = donGia.getDonGia().getGiaNuoc();
            this.hoaDon.setGiaDien(giaDien);
            this.hoaDon.setGiaNuoc(giaNuoc);

            jlbGiaDien.setText(String.valueOf(giaDien));
            jlbGiaNuoc.setText(String.valueOf(giaNuoc));

            jcbTenPhong.setSelectedIndex(indexOfPhong);

//            Date date = new Date();
//            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
//            date = ft.parse("2021-05-19");
//            System.out.println(date);
        }

        java.sql.Date date = new java.sql.Date(2021, 05, 19);
        this.hoaDon.setStartDate(date);
        this.hoaDon.setEndDate(date);

        // set event
        setEvent();
    }

    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int soDien = Integer.valueOf(jtfSoDien.getText().trim());
                int soNuoc = Integer.valueOf(jtfSoNuoc.getText().trim());
                int giaNuoc = hoaDon.getGiaNuoc();
                int giaDien = hoaDon.getGiaDien();

                List<PhongTroDto> dsPhongTro = phongTroService.getAll();
                PhongTroDto phong = dsPhongTro.get(jcbTenPhong.getSelectedIndex());
                int giaPhong = phong.getGiaPhong();

                int tongTien = giaPhong + soDien * giaDien + soNuoc * giaNuoc;

                hoaDon.setSoDien(soDien);
                hoaDon.setSoNuoc(soNuoc);
                hoaDon.setGiaPhong(giaPhong);
                hoaDon.setGiaDien(giaDien);
                hoaDon.setGiaNuoc(giaNuoc);

                hoaDon.setTenPhong((String) jcbTenPhong.getItemAt(jcbTenPhong.getSelectedIndex()));
                hoaDon.setStatusName((String) jcbTinhTrang.getItemAt(jcbTinhTrang.getSelectedIndex()));
                
                System.out.println(jdcStartDate.getDate().toString());
                System.out.println(jdcEndDate.getDate().toString());
                
                hoaDon.setStartDate(covertDateToDateSql(jdcStartDate.getDate()));
                hoaDon.setEndDate(covertDateToDateSql(jdcEndDate.getDate()));
                
                
                hoaDon.setTienPhong(tongTien);
                jlbTienPhong.setText(String.valueOf(tongTien));
                jlbGiaPhong.setText(String.valueOf(giaPhong));

                int lastId;
                if (showDialog("Bạn có muốn lưu dữ liệu không ? ")) {
                    switch (action) {
                        case "update":
                            lastId = hoaDonService.update(hoaDon);
                            if (lastId != 0) {
                                jlbMsg.setText("Cập nhật dữ liệu thành công!");

                            } else {
                                jlbMsg.setText("Có lỗi xảy ra, vui lòng thử lại!");
                            }
                            break;
                        case "insert":
                            lastId = hoaDonService.insert(hoaDon);
                            if (lastId != 0) {
                                jlbMsg.setText("Thêm dữ liệu thành công!");

                            } else {
                                jlbMsg.setText("Có lỗi xảy ra, vui lòng thử lại!");
                            }
                            break;
                        default:
                            break;
                    }
                }

            }

        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showDialog("Bạn có muốn xóa dữ liệu không ?")) {
                    int lastId = hoaDonService.delete(hoaDon.getId());
                    if (lastId != 0) {
                        jlbMsg.setText("Xóa dữ liệu thành công!");

                    } else {
                        jlbMsg.setText("Có lỗi xảy ra, vui lòng thử lại!");
                    }
                }
            }
        });

        btnXuatHoaDon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    XSSFWorkbook workbook = new XSSFWorkbook();
                    XSSFSheet spreadsheet = workbook.createSheet("Hóa đơn");

                    XSSFRow row = null;
                    Cell cell = null;

                    row = spreadsheet.createRow((short) 2);
                    row.setHeight((short) 500);
                    cell = row.createCell(0, CellType.STRING);
                    cell.setCellValue("HÓA ĐƠN");

                    row = spreadsheet.createRow((short) 3);
                    row.setHeight((short) 500);
                    cell = row.createCell(0, CellType.STRING);
                    cell.setCellValue("ID");
                    cell = row.createCell(1, CellType.STRING);
                    cell.setCellValue("Tên phòng");
                    cell = row.createCell(2, CellType.STRING);
                    cell.setCellValue("Start Date");
                    cell = row.createCell(3, CellType.STRING);
                    cell.setCellValue("End Date");
                    cell = row.createCell(4, CellType.STRING);
                    cell.setCellValue("Giá điện");
                    cell = row.createCell(5, CellType.STRING);
                    cell.setCellValue("Giá nước");
                    cell = row.createCell(6, CellType.STRING);
                    cell.setCellValue("Số điện");
                    cell = row.createCell(7, CellType.STRING);
                    cell.setCellValue("Số nước");
                    cell = row.createCell(8, CellType.STRING);
                    cell.setCellValue("Giá phòng");
                    cell = row.createCell(9, CellType.STRING);
                    cell.setCellValue("Tổng tiền");

                    row = spreadsheet.createRow((short) 5);
                    row.setHeight((short) 400);
                    row.createCell(0).setCellValue(hoaDon.getId());
                    row.createCell(1).setCellValue(hoaDon.getTenPhong());
                    row.createCell(2).setCellValue(hoaDon.getStartDate());
                    row.createCell(3).setCellValue(hoaDon.getEndDate());
                    row.createCell(4).setCellValue(hoaDon.getGiaDien());
                    row.createCell(5).setCellValue(hoaDon.getGiaNuoc());
                    row.createCell(6).setCellValue(hoaDon.getSoDien());
                    row.createCell(7).setCellValue(hoaDon.getSoNuoc());
                    row.createCell(8).setCellValue(hoaDon.getGiaPhong());
                    row.createCell(9).setCellValue(hoaDon.getTienPhong());
                    
                    String fileName = "D:/hoaDon_" + hoaDon.getTenPhong() + ".xlsx" ;
                    FileOutputStream out = new FileOutputStream(new File(fileName));
                    workbook.write(out);
                    out.close();
                    jlbMsg.setText("Xuất file thành công (*)");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private boolean showDialog(String act) {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                act, "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }

    public java.sql.Date covertDateToDateSql(Date d) {
        return new java.sql.Date(d.getTime());
    }
}
