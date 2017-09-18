package com.ulisses.persistence;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.ulisses.model.Produto;

public class ProdutoDao extends Dao {

	public void create(Produto p) throws Exception {

		open();
		
		stmt = con.prepareStatement("insert into produto values (null,?,?,?,?)");
		stmt.setString(1, p.getNome());
		stmt.setBigDecimal(2, p.getPreco());
		stmt.setString(3, p.getEstado());
		stmt.setString(4, p.getFoto());
		stmt.execute();

		stmt.close();
		close();
	}

	public List<Produto> findTen() throws Exception {

		ArrayList<Produto> produtos = new ArrayList<Produto>();
		open();
		stmt = con.prepareStatement("select * from produto order by codigo desc limit 10");
		rs = stmt.executeQuery();
		while (rs.next()) {

			Produto p = new Produto();
			p.setCodigo(rs.getInt("codigo"));
			p.setNome(rs.getString("nome"));
			p.setPreco(rs.getBigDecimal("preco"));
			produtos.add(p);

		}

		stmt.close();
		rs.close();
		close();

		return produtos;

	}

	public List<Produto> findByNome(String produto) throws Exception {

		ArrayList<Produto> produtos = new ArrayList<Produto>();
		open();
		stmt = con.prepareStatement("select * from produto where nome like ? ");
		stmt.setString(1, "%" + produto + "%");
		rs = stmt.executeQuery();
		while (rs.next()) {

			Produto p = new Produto();
			p.setCodigo(rs.getInt("codigo"));
			p.setNome(rs.getString("nome"));
			p.setPreco(rs.getBigDecimal("preco"));
			produtos.add(p);

		}

		stmt.close();
		rs.close();
		close();

		return produtos;

	}

	public Produto findById(int codigo) throws Exception {

		Produto p = new Produto();
		open();
		stmt = con.prepareStatement("select * from produto where codigo = ? ");
		stmt.setInt(1, codigo);
		rs = stmt.executeQuery();
		while (rs.next()) {
           
			
			p.setCodigo(rs.getInt("codigo"));
			p.setNome(rs.getString("nome"));
			p.setPreco(rs.getBigDecimal("preco"));
			p.setEstado(rs.getString("estado"));
			p.setFoto(rs.getString("foto"));

		}
		System.out.println(p.getPreco());
		stmt.close();
		rs.close();
		close();

		return p;

	}

	public void update(Produto p) throws Exception {

		open();
		stmt = con.prepareStatement(
				"update produto set nome = ?, preco = ?, estado =?, foto = ? " + "  where codigo = ? ");
		stmt.setString(1, p.getNome());
		stmt.setBigDecimal(2, p.getPreco());
		stmt.setString(3, p.getEstado());
		stmt.setString(4, p.getFoto());
		stmt.setInt(5, p.getCodigo());
		stmt.execute();

		stmt.close();

		close();

	}

	public void delete(Integer codigo) throws Exception {

		open();
		stmt = con.prepareStatement("delete from produto where codigo =  ? ");
		stmt.setInt(1, codigo);
		stmt.execute();

		stmt.close();

		close();

	}

	public List<Produto> vendaPorProduto() throws Exception {

		open();
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		stmt = con.prepareStatement("select nome, sum(preco) preco from produto group by nome ");
		rs = stmt.executeQuery();
		while (rs.next()) {

			Produto p = new Produto();
			p.setNome(rs.getString("nome"));
			p.setPreco(rs.getBigDecimal("preco"));
			produtos.add(p);

		}

		stmt.close();
		rs.close();
		close();

		return produtos;

	}

	public List<Produto> vendaPorEstado() throws Exception {

		open();
		
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		stmt = con.prepareStatement("select nome, estado, sum(preco) preco from produto group by estado, nome order by estado,nome,preco desc ");
		rs = stmt.executeQuery();
		while (rs.next()) {

			Produto p = new Produto();
			p.setNome(rs.getString("nome"));
			p.setEstado(rs.getString("estado"));
			p.setPreco(rs.getBigDecimal("preco"));
			produtos.add(p);

		}

		stmt.close();
		rs.close();
		close();

		return produtos;

	}

}
