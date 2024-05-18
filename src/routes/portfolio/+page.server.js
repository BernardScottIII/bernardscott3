export const load = async (serverLoadEvent) => {
    const { fetch } = serverLoadEvent;
    const response = await fetch('http://localhost:4000/projects') ;
    const projects = await response.json();
    if(response.status == 404) {
        throw redirect(307, '/portfolio/future-project');
    }
    return {
        projects
    };
};