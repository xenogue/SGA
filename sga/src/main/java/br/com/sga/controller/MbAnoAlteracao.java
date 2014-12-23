package br.com.sga.controller;

import br.com.sga.model.dao.HibernateDAO;
import br.com.sga.model.dao.InterfaceDAO;
import br.com.sga.model.entities.Alteracao;
import br.com.sga.model.entities.Ano;
import br.com.sga.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

/**
 *
 * @author rios
 */
@ManagedBean(name="mbAnoAlteracoes")
@RequestScoped
public class MbAnoAlteracao implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private List<Ano> anos;
    private List<Alteracao> alteracoes;
    
    private InterfaceDAO<Ano> anoDAO(){
        InterfaceDAO<Ano> anoDAO = new HibernateDAO<Ano>(Ano.class, FacesContextUtil.getRequestSession());
        return anoDAO;
    }
    
    private InterfaceDAO<Alteracao> alteracoesDAO(){
        InterfaceDAO<Alteracao> alteracoesDAO = new HibernateDAO<Alteracao>(Alteracao.class, FacesContextUtil.getRequestSession());
        return alteracoesDAO;
    }
    
    public void pesquisarPorAno(){
        DetachedCriteria criteriacriteria = DetachedCriteria.forClass(Ano.class).add( Property.forName("ano").eq(1999) );
        List<Ano> anos = anoDAO().getListByDetachedCriteria(criteriacriteria);
        //InterfaceDAO<AnoPDF> anoPDFDAO = anoPDFDAO().getListByDetachedCriteria(criteriacriteria); 
    }
    
    public void pesquisarPorNomePessoa(String parametro){
        DetachedCriteria criteriacriteria = DetachedCriteria.forClass(Ano.class).add( Property.forName("ano").eq(parametro) );
        //InterfaceDAO<AnoPDF> anoPDFDAO = anoPDFDAO().getListByDetachedCriteria(criteriacriteria); 
    }

    public List<Ano> getAnos() {
        if(anos == null) {
            anos = anoDAO().getEntities();
        }
        return anos;
    }

    public void setAnos(List<Ano> anos) {
        this.anos = anos;
    }
    
    
    
//    public void exemplo(){
//        SessionFactory sf = HibernateUtil.getSessionFactory();
//        Session session = sf.openSession();
//        session.beginTransaction();
//  
//         
//        Meeting meeting1 = new Meeting("Quaterly Sales meeting");
//        Meeting meeting2 = new Meeting("Weekly Status meeting");
//         
//        Employee employee1 = new Employee("Sergey", "Brin");
//        Employee employee2 = new Employee("Larry", "Page");
// 
//        employee1.getMeetings().add(meeting1);
//        employee1.getMeetings().add(meeting2);
//        employee2.getMeetings().add(meeting1);
//         
//        session.save(employee1);
//        session.save(employee2);
//         
//        session.getTransaction().commit();
//        session.close();
//    }
//    

    public List<Alteracao> getAlteracoes() {
        if (alteracoes == null) {
            alteracoes = alteracoesDAO().getEntities();
        }
        return alteracoes;
    }

    public void setAlteracoes(List<Alteracao> alteracoes) {
        this.alteracoes = alteracoes;
    }
    
    
    
}
