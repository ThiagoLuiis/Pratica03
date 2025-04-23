package Models;

public class FaturaCliente {
   private int id;
   private Cliente cliente;
   private double valor;

   public FaturaCliente(int id, Cliente cliente, double valor) {
      this.id = id;
      this.cliente = cliente;
      this.valor = valor;
   }

   public FaturaCliente(int id) {
      this.id = id;
      this.cliente = null;
      this.valor = 0.0;
   }

   public int getId() {
      return this.id;
   }

   public Cliente getCliente() {
      return this.cliente;
   }

   public void setCliente(Cliente cliente) {
      this.cliente = cliente;
   }

   public double getValor() {
      return this.valor;
   }

   public void setValor(double valor) {
      this.valor = valor;
   }

   public double getValorComDesconto() {
      if (this.cliente == null) {
         return this.valor;
      } else {
         double desconto = (double)this.cliente.getDesconto() / 100.0;
         return this.valor * (1.0 - desconto);
      }
   }

   public String toString() {
      String clienteInfo = this.cliente != null ? this.cliente.toString() : "sem cliente";
      return "Fatura [id=" + this.id + ", cliente=" + clienteInfo + ", valor=" + String.format("%.2f", this.valor) + "]";
   }
}