/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDeTabela;

import Conexao.ConectaBanco;
import Modelo.Jaula;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rodri
 */
public class JaulaModeloTabela extends AbstractTableModel {
     private ArrayList linhas = null;
    private String[] colunas = null;
    ConectaBanco conectar = new ConectaBanco();
    
    public JaulaModeloTabela(ArrayList lin, String [] col){
        setLinhas(lin);
        setColunas(col);
    }
    public ArrayList getLinhas(){
        return linhas;
    }
    public void setLinhas(ArrayList dados){
        linhas = dados;
    }
    public String[] getColunas(){
        return colunas;
    }
    public void setColunas(String[] nomes){
        colunas = nomes;
    }
    public int getColumnCount(){
        return colunas.length;
    }
    public int getRowCount(){
        return linhas.size();
    }
    public String getColumnName(int numColuna){
        return colunas[numColuna];
    }
    
    public Object getValueAt(int numLinha, int numColuna){
        Object[] linha = (Object[])getLinhas().get(numLinha);
        return linha[numColuna];
    }
}
