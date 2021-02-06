package model;

public class JB {

	private String ID;
    private String NOME;
    private String EMAIL;
    private String SENHA;
    private String TELEFONE;
    
    public JB(){
        super();
    }
    
    public JB(String ID, String NOME, String EMAIL, String SENHA, String TELEFONE){
        super();
        this.ID = ID;
        this.NOME = EMAIL;
        this.SENHA = SENHA;
        this.TELEFONE = TELEFONE;
        
         
    }
    
    public void setID(String ID){
        this.ID = ID;
        
    }
    
    public String getID(){
        return ID;
    }
    
       public void setNOME(String NOME){
        this.NOME = NOME;
        
    }
    
    public String getNOME(){
        return NOME;
    }

       public void setEMAIL(String EMAIL){
        this.EMAIL = EMAIL;
        
    }
    
    public String getEMAIL(){
        return EMAIL;
    }

       public void setSENHA(String SENHA){
        this.SENHA = SENHA;
        
    }
    
    public String getSENHA(){
        return SENHA;
    }

       public void setTELEFONE(String TELEFONE){
        this.TELEFONE = TELEFONE;
        
    }
    
    public String getTELEFONE(){
        return TELEFONE;
    }

	
	
}
