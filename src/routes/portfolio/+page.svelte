<script>
    export let data;
    const projects = data.projects;
</script>
<main>   
    <h1>My Portfolio</h1>
    {#each projects as project}
        <h2><a href={`/portfolio/${project.id}`}>{project.title}</a></h2>
        <p>{project.summary}</p>
    {/each}
</main>