import { page } from '$app/stores';
import { redirect } from '@sveltejs/kit';

export const load = async (loadEvent) => {
    const { fetch, params } = loadEvent;
    const projectId = params.projectId;
    const response = await fetch(`https://bernardscott3-data.onrender.com/projects/projects/${projectId}`);
    if(response.status == 404) {
        throw redirect(307, '/portfolio/future-project');
    }
    const { title, description } = await response.json();
    return {
        title,
        description
    };
};