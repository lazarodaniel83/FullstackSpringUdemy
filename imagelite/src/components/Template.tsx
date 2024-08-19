
interface TemplateProps{
    children: React.ReactNode
}
export const Template: React.FC<TemplateProps> = (props: TemplateProps) =>{
    return (
        <>
            <Header/>
            <div className="container mx-auto mt-8 px-4">
                { props.children }
            </div>
            

            <Footer/>
        </>
    )
}


const Header: React.FC = () =>{
    return( 
        <header className="bg-emerald-500 text-black py-3">
            <div className="container mx-auto flex justify-between item-center px-4">
            <img className="h-15 w-12 object-cover rounded-t-md" src="../logoUnica.png" alt="" />
                <h1 className="text-3x1 font-bold">®Fármacia Homéopatica Única</h1>                
            </div>
        
        </header>
    )
}

const Footer: React.FC = () =>{
    return(
        <footer className="bg-emerald-500 text-black py-3 mt-8">
                <div className="container mx-auto text-center">
                Desenvolvido por Lazaro Daniel Santos Souza
                </div>
        </footer>
    )
}

