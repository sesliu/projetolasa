package com.ulisses.webservices;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ulisses.model.Produto;
import com.ulisses.persistence.ProdutoDao;

@RestController
@RequestMapping("/api")
public class ProdutoResource {

	@CrossOrigin
	@RequestMapping(value = "/produtos", method = RequestMethod.GET)
	public List<Produto> listar2() {

		List<Produto> lst = new ArrayList<Produto>();

		try {
			lst = new ProdutoDao().findTen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lst;
	}

	@CrossOrigin
	@RequestMapping(value = "/gravar", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public String gravar(@RequestBody Produto produto) {

		ProdutoDao dao = new ProdutoDao();
		String resultado;

		try {

			dao.create(produto);

			resultado = new ResponseEntity(null).status(HttpStatus.OK).toString();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			resultado = new ResponseEntity(null).status(HttpStatus.BAD_REQUEST).toString();
		}

		return resultado;
	}

	@CrossOrigin
	@RequestMapping(value = "/busca/{produto}", method = RequestMethod.GET, produces = "application/json")
	public List<Produto> busca(@PathVariable("produto") String produto) {

		List<Produto> lst = new ArrayList<Produto>();
		try {
			lst = new ProdutoDao().findByNome(produto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lst;
	}

	@CrossOrigin
	@RequestMapping(value = "/edita/{codigo}", method = RequestMethod.GET, produces = "application/json")
	public Produto edita(@PathVariable("codigo") Integer codigo) throws Exception {

		return new ProdutoDao().findById(codigo);

	}

	@CrossOrigin
	@RequestMapping(value = "/atualiza", method = RequestMethod.POST, consumes = "application/json")
	public void atualiza(@RequestBody Produto produto) throws Exception {

		new ProdutoDao().update(produto);

	}

	@CrossOrigin
	@RequestMapping(value = "/exclui/{codigo}", method = RequestMethod.DELETE, produces = "application/json")
	public void atualiza(@PathVariable Integer codigo) throws Exception {

		new ProdutoDao().delete(codigo);

	}

	@CrossOrigin
	@RequestMapping(value = "/vendaProduto", method = RequestMethod.GET)
	public List<Produto> vendaProduto() {

		List<Produto> lst = new ArrayList<Produto>();

		try {
			lst = new ProdutoDao().vendaPorProduto();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lst;
	}

	@CrossOrigin
	@RequestMapping(value = "/vendaEstado", method = RequestMethod.GET)
	public List<Produto> vendaEstado() {

		List<Produto> lst = new ArrayList<Produto>();

		try {
			lst = new ProdutoDao().vendaPorEstado();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lst;
	}

}
