'use client'
import {Template,ImageCard} from '@/components/'
import {Image} from '@/resources/image/image.resource';
import {useImageService} from '@/resources/image/image.service'
import {useState} from 'react'

export default function GaleriaPage(){

    const useService = useImageService();
    const [images, setImages] = useState<Image[]>([])

    async function searchImages(){
        const result = await useService.buscar();
        setImages(result);
        console.log(images)
    }

    return(
        <Template>
            <button className='text-xl font-semibold mb-2 text-gray-600' onClick={searchImages}>Clique para mudar</button>
            <section className='grid grid-cols-4 gap-8'>
                <ImageCard nome="{nomeImage}" tamanho='10MB' dataUpload='12/08/2024' src=""/>
                               
            </section>         
        </Template>
       
    )
}