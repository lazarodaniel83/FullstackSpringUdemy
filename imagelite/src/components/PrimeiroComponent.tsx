'use client'

interface PrimeiroComponentprops{
    messagem: string;
    mesagemDoBotao: string;
}

export const PrimeiroComponent: React.FC<PrimeiroComponentprops> = (props: PrimeiroComponentprops) => {

    function handleClick(){
        console.log(props.mesagemDoBotao)
    }

    return(
        <div>
            {props.messagem}
            <br></br>
            <button onClick={handleClick}>Clique aqui</button>
        </div>
    )
}

export const ArrowFunction = () => {
    return (
        <h2>Arrow Function</h2>
    )
}