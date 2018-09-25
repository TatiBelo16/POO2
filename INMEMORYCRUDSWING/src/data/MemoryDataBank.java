/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.List;
import model.Programador;

/**
 *
 * @author crfranco
 */
public class MemoryDataBank implements IDao<Programador>{
    
    private List<Programador> memoryDataBank = new ArrayList<>(); 

    @Override
    public void save(Programador t) {
        this.memoryDataBank.add(t);
    }

    @Override
    public Programador getOne(int id) {
        for (Programador programador: memoryDataBank){
            if (programador.getCodigo() == id)
                return programador;
        }
        return null;
    }

    @Override
    public List<Programador> list() {
        return memoryDataBank;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Programador t) {
        for (Programador programador: memoryDataBank){
            if (programador.getCodigo() == t.getCodigo())
                this.memoryDataBank.set(memoryDataBank.indexOf(programador),t);
        }
    }

    @Override
    public void delete(int id) {
        for (Programador programador: memoryDataBank){
            if (programador.getCodigo() == id)
                this.memoryDataBank.remove(programador);
        }
    }
    
    public List<Programador> getByName(String name){
        List<Programador> retorno = new ArrayList<>(); 

        for (Programador programador : this.memoryDataBank) {
            if (programador.getNome().indexOf(name) >= 0) {
                retorno.add(programador);
            }
        }  
        return retorno;
    }
   
    
}
