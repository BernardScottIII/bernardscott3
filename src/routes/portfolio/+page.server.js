export const load = async (serverLoadEvent) => {
    const { fetch } = serverLoadEvent;
    const response = await fetch(`https://bernardscott3-data.onrender.com/projects`) ;
    const projects = await response.json();
    if(response.status == 404) {
        throw redirect(307, '/portfolio/future-project');
    }
    return {
        projects
    };
};