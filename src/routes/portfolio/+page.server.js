export const load = async (serverLoadEvent) => {
    const { fetch } = serverLoadEvent;
    const response = await fetch('http://localhost:4000/projects') ;
    const projects = await response.json();
    return {
        projects
    };
};