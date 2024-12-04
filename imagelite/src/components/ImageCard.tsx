'use client'

interface ImageCardProps{
    nome?: string;
    tamanho?: number;
    dataUpload?: string;
    src?: string;
    extension?: string;
}

export const ImageCard: React.FC<ImageCardProps> = ({
    nome, dataUpload, src, tamanho,extension

}: ImageCardProps) => {

     function download(){
        window.open(src, '_blank')
     }
        
    return(
        <div onClick={download} className="card reative bg-white rounded-md transition-transform ease-in duration-300 transfor hover:shadow-lg hover:translate-y-2">
            <img src={src} className="h-13 w-30 object-cover rounded-t-md" alt="" />
            <div className="card-body p-4">
                <h5 className="text-xl font-semibold mb-2 text-gray-600">{nome}</h5>
                <p className="text-gray-600">{extension}</p>
                <p className="text-gray-600">{formatBytes(tamanho)}</p>
                <p className="text-gray-600">{dataUpload}</p>
            </div>
        </div>
    )
}    

function formatBytes(bytes: number =0, decimals = 2){
    if(!+bytes) return 'o Bytes';

    const k = 1024;
    const dm = decimals < 0? 0 :decimals
    const sizes = ['Bytes', 'KB','MB','GB']

    const i = Math.floor(Math.log(bytes) / Math.log(k))

    return `${parseFloat((bytes / Math.pow(k, i)).toFixed(dm))} ${sizes[i]}`
}
