<script>
    export let data;
    const title = data.title;
    const description = data.description;
    const dataStructure = data.dataStructure;
</script>

<p><a href="/portfolio">Back</a></p>
<h1>Project details about {title}</h1>
<p>{description}</p>

{#each dataStructure as structure}
<h2>{structure.title}</h2>
<p>{structure.summary}</p>
{/each}