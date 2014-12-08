//
//package br.com.sga.controller;
//
//import br.com.sga.model.dao.HibernateDAO;
//import br.com.sga.model.dao.InterfaceDAO;
//import br.com.sga.model.entities.Cidade;
//import br.com.sga.util.FacesContextUtil;
//import java.io.Serializable;
//import java.util.List;
//import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
//import javax.faces.context.FacesContext;
//
///**
// *
// * @author rios
// */
//@ManagedBean(name="mbCidade")
//@RequestScoped
//public class MbCidade implements Serializable {
//    
//    private static final long serialVersionUID = 1L;
//    private Cidade cidade = new Cidade();
//    private List<Cidade> cidades;
//
//    public MbCidade() {
//    }
//    
//    private InterfaceDAO<Cidade> cidadeDAO(){
//        InterfaceDAO<Cidade> cidadeDAO = new HibernateDAO<Cidade>(Cidade.class, FacesContextUtil.getRequestSession());
//        return cidadeDAO;
//    }
//    
//    public String limpCidade() {
//        cidade = new Cidade();
//        return editCidade();
//    }
//    
//    public String editCidade(){
//        return "/restrict/cadastrarcidade.faces";
//    }
//    
//    public String addCidade(){
//        if(cidade.getNome() != ""){
//            FacesContext.getCurrentInstance().addMessage(null,
//                new FacesMessage(FacesMessage.SEVERITY_INFO, "Cidade já cadastrada", ""));
//            return null;
//        }
//        if(cidade.getIdCidade() == null || cidade.getIdCidade() == 0 ) {
//            insertCidade();
//        } else{
//            updateCidade();
//        }
//        limpCidade();
//        return null;
//    }
//
//    private void insertCidade() {
//        cidadeDAO().save(cidade); 
//        FacesContext.getCurrentInstance().addMessage(null,
//                new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
//    }
//
//    private void updateCidade() {
//        cidadeDAO().update(cidade);
//        FacesContext.getCurrentInstance().addMessage(null,
//                new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
//    }
//    
//    public void deleteCidade() {
//        cidadeDAO().remove(cidade);
//        FacesContext.getCurrentInstance().addMessage(null,
//                new FacesMessage(FacesMessage.SEVERITY_INFO, "Cidade excluída com sucesso", ""));
//    }
//
//    public Cidade getCidade() {
//        return cidade;
//    }
//
//    public void setCidade(Cidade cidade) {
//        this.cidade = cidade;
//    }
//
//    public List<Cidade> getCidades() {
//        cidades = cidadeDAO().getEntities();
//        return cidades;
//    }
//
//    public void setCidades(List<Cidade> cidades) {
//        this.cidades = cidades;
//    }
//    
//    
//    
//}
