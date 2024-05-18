import { page } from '$app/stores';
import { redirect } from '@sveltejs/kit';

export const load = async (loadEvent) => {
    const { fetch } = loadEvent;
    const response = await fetch(`http://localhost:4000/projects/dsa-mastery`);
    if(response.status == 404) {
        throw redirect(307, '/portfolio/future-project');
    }
    const { title, description } = await response.json();
    response = await fetch('http://localhost:4000/data-structures');
    const { dataStructure } = await response.json();
    return {
        title,
        description,
        dataStructure
    };
};

/* export const loadAllResponses = await Promise.all(
    urls.map((url) =>
        fetch(url)
            .then((res) => res.json())
    )
); */