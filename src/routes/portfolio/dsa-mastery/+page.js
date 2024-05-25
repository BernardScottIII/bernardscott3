import { page } from '$app/stores';
import { redirect } from '@sveltejs/kit';

export const load = async ({ fetch }) => {
    const projResponse = await fetch(`https://bernardscott3-data.onrender.com/projects/dsa-mastery`);
    const dataResponse = await fetch(`https://bernardscott3-data.onrender.com/data-structures`);
    if(projResponse.status == 404 || dataResponse == 404) {
        throw redirect(307, '/portfolio/future-project');
    }
    const { title, description } = await projResponse.json();
    const dataStructure = await dataResponse.json();
    return {
        title,
        description,
        dataStructure
    };
};
