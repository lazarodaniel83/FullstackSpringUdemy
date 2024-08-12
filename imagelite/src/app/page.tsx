import { PrimeiroComponent, ArrowFunction} from '../components/PrimeiroComponent'

//node = nó
export default function Home() {
  return (
    <div>
      <PrimeiroComponent 
        messagem='Olá, esta mensagem estou passando por parametro'
        mesagemDoBotao='Esta é a mensagem do botão'/>
      <ArrowFunction/>
      <PrimeiroComponent 
        messagem='Sou outro componente'
        mesagemDoBotao='Clicaram em mim'/>
      <ArrowFunction/>
    </div>
    
    
  )
}
